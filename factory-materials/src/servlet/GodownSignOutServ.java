package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 仓库管理员退出系统
 */
@WebServlet("/GodownSignOutServ")
public class GodownSignOutServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		request.getSession().setAttribute("godownKeeper", null);
		Object godownKeeper = request.getSession().getAttribute("godownKeeper");
		if(godownKeeper==null) {
			request.getRequestDispatcher("/godownKeeper/signoutSuccess.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
