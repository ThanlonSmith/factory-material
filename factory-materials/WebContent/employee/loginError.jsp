<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录失败</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 30px">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-primary">
					<div class="panel-body text-center">登录失败，3秒后返回登录页面！</div>
				</div>
			</div>
		</div>
	</div>
<script>
setInterval(() => {
	window.location.href="<%=path%>/employee/employee_login.jsp";
}, 3000);
</script>
</body>
</html>