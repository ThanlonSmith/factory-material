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
import entity.Department;
import entity.GodownKeeper;

/**
 * Servlet implementation class DepartmentInfoServ
 */
@WebServlet("/DepartmentInfoServ")
public class DepartmentInfoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao ad = new AdminDao();
		List<Department> list;
		try {
			list = ad.queryDepartInfo();
			for (Department gk : list) {
				gk.getId();
				gk.getName();
			}
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				System.out.println(list);
				request.getRequestDispatcher("/admin/department.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
