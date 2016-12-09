package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jdbc.daoImpl.UserDaoImpl;
import jdbc.entity.User;

@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDaoImpl = new UserDaoImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		String para = request.getParameter("para");
		String rule = "\\d{0,}$";
		
		String result = "";
		if (para.matches(rule))
			result = getUserById(para);
		else
			result = getUserByName(para);
		out.write(result);
		out.flush();
		out.close();
	}

	private String getUserByName(String para) {
		User user = userDaoImpl.queryUserByName(para);
		Gson gson = new Gson();
		return gson.toJson(user);
	}

	private String getUserById(String para) {
		StringBuilder str = new StringBuilder();
		
		return str.toString();
	}

}
