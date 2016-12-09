package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.daoImpl.UserDaoImpl;
import jdbc.entity.User;

@WebServlet("/AlterUserServlet")
public class AlterUserServlet extends HttpServlet{
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	protected void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		User u = new User();
		
		u.setId(Integer.parseInt(request.getParameter("uid")));
		u.setName(request.getParameter("uname"));
		u.setPwd(request.getParameter("upwd"));
		u.setDate(request.getParameter("udate"));
		u.setPhone(request.getParameter("uphone"));
		
		boolean flag = userDaoImpl.updateUser(u);
		if(flag)
			request.getRequestDispatcher("alterSuccess.jsp").forward(request, response);
	}
}
