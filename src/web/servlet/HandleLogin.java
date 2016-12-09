package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.daoImpl.UserDaoImpl;
import jdbc.entity.User;

@WebServlet("/HandleLogin")
public class HandleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDaoImpl  userDaoImpl = new UserDaoImpl();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		boolean flag = userDaoImpl.checkUser(uname, pwd);
		if(flag){
			User u = new User();
			u.setName(uname);
			u.setPwd(pwd);
			request.getSession().setAttribute("user", uname);
			response.sendRedirect("index.jsp");
		}
		else
			response.sendRedirect("login.jsp");
	}

}
