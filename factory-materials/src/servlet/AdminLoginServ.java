package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;

@WebServlet("/AdminLoginServ")
public class AdminLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at:").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = new String(request.getParameter("name").getBytes("ISO8859_1"), "utf-8");
		String pwd = new String(request.getParameter("pwd").getBytes("ISO8859_1"), "utf-8");
		AdminDao adminDao = new AdminDao();
		if (adminDao.login(name, pwd)) {
			request.getSession().setAttribute("admin", name);
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/admin/loginError.jsp").forward(request, response);
		}
	}

}
