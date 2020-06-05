package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.GodownKeeperDao;
import entity.GodownKeeper;
import entity.Warehouse;


@WebServlet("/GodownKeeperInfoServ")
public class GodownKeeperInfoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao ad = new AdminDao();
		List<GodownKeeper> list;
		try {
			list = ad.queryGodownKeepersInfo();
//			System.out.println(list);
			for (GodownKeeper gk : list) {
				gk.getId();
				gk.getName();
				gk.getGodown_id();
				gk.getMobile_number();
				gk.getReal_name();
			}
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				System.out.println(list);
				request.getRequestDispatcher("/admin/godownKeeper.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
