<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String username = (String) session.getAttribute("username");
	//System.out.print(admin);
	if (username == null || "".equals(username)) {
		response.sendRedirect("" + path + "/user/user_login.jsp");
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