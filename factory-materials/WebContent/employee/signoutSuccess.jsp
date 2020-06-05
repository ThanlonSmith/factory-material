<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String emp = (String) session.getAttribute("emp");
	//System.out.print(emp);
	if (emp == null || "".equals(emp)) {
		response.sendRedirect("" + path + "/employee/employee_login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>