package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.prism.Material;

import dao.UserDao;
import entity.MaterialApply;


@WebServlet("/InsertMaterialApply")
public class InsertMaterialApply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		String name = request.getParameter("name");
		String applicant = request.getParameter("applicant");
		String address = request.getParameter("address");
		String mobile_nubmer = request.getParameter("mobile_nubmer");
		String others = request.getParameter("others");
		MaterialApply ma = new MaterialApply();
		ma.setName(name);
		ma.setMobile_nubmer(mobile_nubmer);
		ma.setApplicant(applicant);
		ma.setAddress(address);
		ma.setOthers(others);
		UserDao uDao = new UserDao();
		if (uDao.addMaterialApply(ma)) {
			request.getRequestDispatcher("/user/apply_success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/user/apply_error.jsp").forward(request, response);
		}
	}

}
