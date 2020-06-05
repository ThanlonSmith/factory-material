package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import entity.Department;
import entity.Employee;

/**
 * Servlet 修改员工信息
 */
@WebServlet("/UpdateEmpInfoServ")
public class UpdateEmpInfoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		String name = new String(request.getParameter("name").getBytes("ISO8859_1"), "utf-8");
		String mobile_number = new String(request.getParameter("mobile_number").getBytes("ISO8859_1"), "utf-8");
		String real_name = new String(request.getParameter("real_name").getBytes("ISO8859_1"), "utf-8");
		Employee em=new Employee();
		AdminDao aDao = new AdminDao();
		em.setId(id);
		em.setName(name);
		em.setMobile_number(mobile_number);
		em.setReal_name(real_name);
		if (aDao.updateEmpInfo(em)) {
			request.getRequestDispatcher("/EmployeeInfoServ").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
