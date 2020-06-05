<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%
	String username = (String) session.getAttribute("admin");
//System.out.print(admin);
if (username == null || "".equals(username)) {
	response.sendRedirect("" + path + "/user/user_login.jsp");
}
%>
<%@page import="java.util.List"%>
<%@page import="entity.Department"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>工厂物料管理系统</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body style="margin-top: 65px">
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="<%=path%>/QueryAssetInfoServ?page=1">仓库管理员信息管理</a></li>
				<li class="active">仓库管理员信息编辑</li>
			</ol>
			<form action="<%=path%>/UpdateGodownKeepersServ" method="POST"
				class="col-md-4 col-md-offset-4">
				<div class="form-group ">
					<label for="exampleInputEmail1">您正在修改的仓库管理员编号为<%
						String id = request.getParameter("id");
					out.print(id);
					%>：
					</label>
					<div hidden>
						<input type="input" class="form-control" id="exampleInputEmail1"
							placeholder="" name="id" value="<%=id%>">
					</div>
					<input type="input" class="form-control" id="exampleInputEmail1"
						placeholder="请输入仓库管理员用户名" name="name"><br>
						<input type="input" class="form-control" id="exampleInputEmail1"
						placeholder="请输入仓库管理员电话号码" name="mobile_number" maxlength="11"><br>
						<input type="input" class="form-control" id="exampleInputEmail1"
						placeholder="请输入仓库管理员真实姓名" name="real_name">
				</div>
				<button type="submit" class="btn btn-primary"
					style="background: #a94442">修改</button>
				<a class="btn btn-primary" style="background: #a94442"
					href="http://localhost:8080/factory-materials/GodownKeeperInfoServ">取消</a>
			</form>

		</div>
	</div>
	<%@include file="../bottom.jsp"%>
</body>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</html>