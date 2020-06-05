package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;


@WebServlet("/EmpLoginServ")
public class EmpLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = new String(request.getParameter("name").getBytes("ISO8859_1"), "utf-8");
		String pwd = new String(request.getParameter("pwd").getBytes("ISO8859_1"), "utf-8");
		EmployeeDao employeeDao = new EmployeeDao();
		if (employeeDao.login(name, pwd)) {
			request.getSession().setAttribute("emp", name);
			request.getRequestDispatcher("/employee/index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/employee/loginError.jsp").forward(request, response);
		}
	}

}
