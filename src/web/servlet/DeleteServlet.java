package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.daoImpl.UserDaoImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDaoImpl = new UserDaoImpl();   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("uid");
		boolean flag = userDaoImpl.deleteUserById(Integer.parseInt(id));
		
		if(flag)
			request.getRequestDispatcher("deleteSuccess.jsp").forward(request, response);
	}
}
