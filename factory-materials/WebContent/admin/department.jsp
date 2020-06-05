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
				<li><a href="<%=path%>/QueryAssetInfoServ?page=1">部门信息管理</a></li>
				<li class="active">部门信息查询</li>
			</ol>
			
			<table class="table table-hover">
			<!--  
			<a href="<%=path%>/admin/add_department.jsp" type="button" class="btn btn-primary" style="background: #a94442">添加部门信息</a>
				-->
				<tr>
					<th>部门ID</th>
					<th>名称</th>
					<th>操作</th>
				</tr>
			<%
					List<Department> list = (List<Department>) request.getAttribute("list");
				if (list == null || list.size() < 1) {
					out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有查到仓库管理员信息！</td></tr>");
				} else {
					for (Department v : list) {
				%>
				<tr>
					<td><%=v.getId()%></td>
					<td><%=v.getName()%></td>
					<td><a
						href="<%=path%>/admin/edit_depart.jsp?id=<%=v.getId()%>&name=<%=v.getName()%>">编辑</a>
						<a href="<%=path%>/DelDepartmentInfoServ?id=<%=v.getId()%>"
						onclick="return confirm('确认删除？')">&nbsp;&nbsp;删除</a></td>
				</tr>
				<%
					}
				}
				%>
			</table>
	
		</div>
	</div>
	<%@include file="../bottom.jsp"%>
</body>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</html>