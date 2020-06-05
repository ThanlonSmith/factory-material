package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.MaterialApply;
import entity.MaterialApplyEmp;

/**
 * Servlet implementation class QueryMaterialApplyInfoEmp
 */
@WebServlet("/QueryMaterialApplyInfoEmp")
public class QueryMaterialApplyInfoEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDao ed = new EmployeeDao();
		List<MaterialApplyEmp> list;
		try {
			list = ed.queryMaterialApplies();
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
//				System.out.println(list); 
				request.getRequestDispatcher("employee/orders_manage.jsp").forward(request, response);
			}else { 
				request.getRequestDispatcher("employee/orders_manage.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
