package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.GodownKeeperDao;
import entity.Department;
import entity.Warehouse;

/**
 * Servlet 修改部门
 */
@WebServlet("/UpdateDepartmentInfoServ")
public class UpdateDepartmentInfoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		String name = new String(request.getParameter("name").getBytes("ISO8859_1"), "utf-8");
		Department dt=new Department();
		AdminDao aDao = new AdminDao();
		dt.setId(id);
		dt.setName(name);
		if (aDao.updateDepartment(dt)) {
			request.getRequestDispatcher("/DepartmentInfoServ").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
