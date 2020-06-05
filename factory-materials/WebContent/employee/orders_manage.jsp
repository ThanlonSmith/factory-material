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
<%@page import="java.util.List"%>
<%@page import="entity.MaterialApplyEmp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工(接单员)工厂物料管理系统</title>
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
			<!-- <li><a href="<%=path%>/QueryAssetInfoServ?page=1">物料信息管理</a></li> -->
				<li class="active">物料申请信息</li>
			</ol> 
			<table class="table table-hover">
				<tr>
					<th>物料编号</th>
					<th>物料名称</th>
					<th>物料单价</th>
					<th>所属仓库</th>
					<th>操作</th>
				</tr>
				<%
					List<MaterialApplyEmp> list = (List<MaterialApplyEmp>) request.getAttribute("list");
				if (list == null || list.size() < 1) {
					out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有来自用户的申请！</td></tr>");
				} else {
					for (MaterialApplyEmp v : list) {
				%>
				<tr>
				<%
				if(v.getFlag()==0){
				%>
					<td><%=v.getMaterial_id()%></td>
					<td><%=v.getName()%></td>
					<td><%=v.getUnit_price()%></td>
					<td><%=v.getGodown_id()%></td>
					<td>
						<a href="<%=path%>/EditMaterialApply?apply_id=<%=v.getApply_id()%>"
						onclick="return confirm('确认同意？')">&nbsp;&nbsp;同意申请</a></td> 
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