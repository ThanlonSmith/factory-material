<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String admin = (String) session.getAttribute("godownKeeper");
	//System.out.print(godownKeeper);
	if (admin == null || "".equals(admin)) {
		response.sendRedirect("" + path + "/godownKeeper/godownKeeper_login.jsp");
	}
%>
<%@page import="java.util.List"%>
<%@page import="entity.MaterialApplyEmp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>仓库管理员-工厂物料管理系统</title>
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
				<li><a href="<%=path%>/QueryAssetInfoServ?page=1">物料申请信息管理</a></li>
				<li class="active">物料申请记录查询</li>
			</ol>
			<div style="color:red;font-weight:bold">该记录留作历史数据，只供查询。抱歉，您没有其它操作权限！</div><br> 
			<table class="table table-hover">
			<tr>
					<th>物料编号</th>
					<th>物料名称</th>
					<th>物料单价</th>
					<th>所属仓库</th>
					<th>申请人</th> 
				</tr>
			<%
					List<MaterialApplyEmp> list = (List<MaterialApplyEmp>) request.getAttribute("list");
				if (list == null || list.size() < 1) {
					out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有来自接单员的同意的申请！</td></tr>");
				} else {
					for (MaterialApplyEmp v : list) {
				%>
				<tr>
				<%
				if(v.getFlag()==1){
				%>
					<td><%=v.getMaterial_id()%></td>
					<td><%=v.getName()%></td>
					<td><%=v.getUnit_price()%></td>
					<td><%=v.getGodown_id()%></td>
					<td><%=v.getApplicant()%></td>
					<%} %>
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