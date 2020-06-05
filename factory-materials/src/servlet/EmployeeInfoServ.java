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
import entity.Employee;

/**
 * Servlet implementation class EmployeeInfoServ
 */
@WebServlet("/EmployeeInfoServ")
public class EmployeeInfoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao ad = new AdminDao();
		List<Employee> list;
		try {
			list = ad.queryEmpInfo();
			for (Employee em : list) {
				em.getId();
				em.getName(); 
				em.getReal_name();
			}
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
				//System.out.println(list);
				request.getRequestDispatcher("/admin/employee.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
