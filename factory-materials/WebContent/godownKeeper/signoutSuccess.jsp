<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String godownKeeper = (String) session.getAttribute("godownKeeper");
	//System.out.print(godownKeeper);
	if (godownKeeper == null || "".equals(godownKeeper)) {
		response.sendRedirect("" + path + "/godownKeeper/godownKeeper_login.jsp");
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