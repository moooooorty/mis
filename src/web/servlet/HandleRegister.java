package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.daoImpl.UserDaoImpl;
import jdbc.entity.User;

@WebServlet("/HandleRegister")
public class HandleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl  userDaoImpl = new UserDaoImpl();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname"); 
		String pwd = request.getParameter("upwd"); 
		String phone = request.getParameter("utel");
		User user = new User();
		user.setName(uname);
		user.setPwd(pwd);
		user.setPhone(phone);
		boolean flag = userDaoImpl.insertUser(user);
		if(flag)
			response.sendRedirect("login.jsp");
		else 
			response.sendRedirect("register.html");
	}

}
