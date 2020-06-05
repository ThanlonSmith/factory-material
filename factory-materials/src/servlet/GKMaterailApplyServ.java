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
import entity.MaterialApplyEmp;

/**
 * Servlet implementation class GKMaterailApplyServ
 */
@WebServlet("/GKMaterailApplyServ")
public class GKMaterailApplyServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GodownKeeperDao gkd = new GodownKeeperDao();
		List<MaterialApplyEmp> list;
		try {
			list = gkd.queryMaterialApplies();
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				//System.out.println(list);
				request.getRequestDispatcher("/godownKeeper/materials_apply.jsp").forward(request, response);
			}else { 
				request.getRequestDispatcher("/godownKeeper/materials_apply.jsp").forward(request, response);
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
