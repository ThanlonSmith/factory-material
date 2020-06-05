package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GodownKeeperDao;

/**
 * Servlet 仓库管理员登录
 */
@WebServlet("/GodownLoginServ")
public class GodownLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = new String(request.getParameter("name").getBytes("ISO8859_1"), "utf-8");
		String pwd = new String(request.getParameter("pwd").getBytes("ISO8859_1"), "utf-8");
		GodownKeeperDao godownKeeperDao = new GodownKeeperDao();
		if (godownKeeperDao.login(name, pwd)) {
			request.getSession().setAttribute("godownKeeper", name);
			request.getRequestDispatcher("/godownKeeper/index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/godownKeeper/loginError.jsp").forward(request, response);
		}
	}

}
