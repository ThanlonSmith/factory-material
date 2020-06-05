package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import entity.Department;
import entity.GodownKeeper;

/**
 * Servlet 修改仓库管理员信息
 */
@WebServlet("/UpdateGodownKeepersServ")
public class UpdateGodownKeepersServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		String name = new String(request.getParameter("name").getBytes("ISO8859_1"), "utf-8");
		String mobile_number = new String(request.getParameter("mobile_number").getBytes("ISO8859_1"), "utf-8");
		String real_name = new String(request.getParameter("real_name").getBytes("ISO8859_1"), "utf-8");
		GodownKeeper gk=new GodownKeeper();
		AdminDao aDao = new AdminDao();
		gk.setId(id);
		gk.setName(name);
		gk.setMobile_number(mobile_number);
		gk.setReal_name(real_name);
		if (aDao.updateGodownKeepersInfo(gk)) {
			request.getRequestDispatcher("/GodownKeeperInfoServ").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
