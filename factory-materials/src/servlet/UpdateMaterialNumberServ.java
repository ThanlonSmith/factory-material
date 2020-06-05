package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GodownKeeperDao;
import entity.Warehouse;

/**
 * Servlet implementation class UpdateMaterialNumberServ
 */
@WebServlet("/UpdateMaterialNumberServ")
public class UpdateMaterialNumberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		int material_number = Integer.parseInt(request.getParameter("material_number"));
		System.out.println(material_number);
		Warehouse wh = new Warehouse();
		wh.setId(id);
		wh.setMn(material_number);
		System.out.println(id);
		GodownKeeperDao gkDao = new GodownKeeperDao();
		if (gkDao.updateGodown(wh)) {
			request.getRequestDispatcher("/WarehouseDataServ").forward(request, response);
		} else {
			request.getRequestDispatcher("/godownKeeper/updateMatealNumberError.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
