package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.MaterialApply;
/**
 * Servlet implementation class EditMaterialApply
 */
@WebServlet("/EditMaterialApply")
public class EditMaterialApply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int apply_id = Integer.parseInt(request.getParameter("apply_id"));
		MaterialApply ma = new MaterialApply();
//		System.out.println(apply_id);
		ma.setId(apply_id);
		EmployeeDao ed = new EmployeeDao();
		if (ed.materialApplyEdit(ma)) {
			request.getRequestDispatcher("/QueryMaterialApplyInfoEmp").forward(request, response);
		} else {
			request.getRequestDispatcher("/admin/editAssetErr.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
