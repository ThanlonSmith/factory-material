package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.GodownKeeperDao;
import entity.Admin;

/**
 * Servlet 删除仓库管理员信息的servet类
 */
@WebServlet("/DelGodownKeepersInfoServ")
public class DelGodownKeepersInfoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AdminDao aDao = new AdminDao();
		try {
			if (aDao.delGodownKeepersInfo(id)) {
					request.getRequestDispatcher("/GodownKeeperInfoServ").forward(request, response);
			}
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
