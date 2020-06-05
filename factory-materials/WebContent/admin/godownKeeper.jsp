<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%
	String username = (String) session.getAttribute("admin");
//System.out.print(admin);
if (username == null || "".equals(username)) {
	response.sendRedirect("" + path + "/admin/admin_login.jsp");
}
%>
<%@page import="java.util.List"%>
<%@page import="entity.GodownKeeper"%>
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
<body onload="showTime();" style="margin-top: 65px">
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="<%=path%>/QueryAssetInfoServ?page=1">仓库管理员信息管理</a></li>
				<li class="active">仓库管理员信息查询</li>
			</ol>
			<table class="table table-hover">
				<tr>
					<th>仓库管理员编号</th>
					<th>仓库管理员用户名</th>
					<th>负责的仓库编号</th>
					<th>手机号</th>
					<th>仓库管理员姓名</th>
					<th>操作</th>
				</tr>
				<%
					List<GodownKeeper> list = (List<GodownKeeper>) request.getAttribute("list");
				if (list == null || list.size() < 1) {
					out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有查到仓库管理员信息！</td></tr>");
				} else {
					for (GodownKeeper v : list) {
				%>
				<tr>
					<td><%=v.getId()%></td>
					<td><%=v.getName()%></td>
					<td><%=v.getGodown_id()%></td>
					<td><%=v.getMobile_number()%></td>
					<td><%=v.getReal_name()%></td>
					<td><a
						href="<%=path%>/admin/edit_godownkeeper.jsp?id=<%=v.getId()%>">编辑</a>
						<a href="<%=path%>/DelGodownKeepersInfoServ?id=<%=v.getId()%>"
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

</html>
