package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GodownKeeperDao;

/**
 * Servlet implementation class DelGodownServ
 */
@WebServlet("/DelGodownServ")
public class DelGodownServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		GodownKeeperDao gkd = new GodownKeeperDao();
		if (gkd.del_godown(id)) {
			request.getRequestDispatcher("/WarehouseDataServ").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
