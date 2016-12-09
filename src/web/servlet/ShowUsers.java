package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.daoImpl.UserDaoImpl;
import jdbc.entity.Page;
import jdbc.entity.User;


@WebServlet("/ShowUsers")
public class ShowUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		List<User> list = userDaoImpl.listUsers();
		Page page = new Page();
		page.setTotalCount(list.size());
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null)
			page.setCurrentPage(1);
		else
			page.setCurrentPage(Integer.parseInt(currentPage));
		
		page.setTotalPages((page.getTotalCount()+page.getPageSize()-1)/page.getPageSize());
		page.setPageStart((page.getCurrentPage()-1)*5);
		
		if(page.getCurrentPage()==page.getTotalPages())
			page.setPageEnd(page.getTotalCount());
		else
			page.setPageEnd(page.getPageStart()+page.getPageSize()-1);
		
		request.setAttribute("listUsers", list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("listUsers.jsp").forward(request, response);
	}
}
