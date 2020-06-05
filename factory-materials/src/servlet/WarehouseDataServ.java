package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GodownKeeperDao;
import entity.Warehouse;

/**
 * Servlet 仓库数据接口
 */
@WebServlet("/WarehouseDataServ")
public class WarehouseDataServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GodownKeeperDao dkd = new GodownKeeperDao();
		List<Warehouse> list;
		try {
			list = dkd.queryWarehouseData();
//			System.out.println(list);
//			for (Warehouse warehouse : list) {
//				warehouse.getId();
//				warehouse.getMaterial_number();
//			}
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("/godownKeeper/warehouse_info.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/godownKeeper/warehouse_info.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
