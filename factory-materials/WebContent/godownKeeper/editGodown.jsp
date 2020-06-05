<%@page import="java.util.ArrayList"%>
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
<%@page import="entity.Warehouse"%>
<%@page import="java.lang.Integer"%>
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
		<div class="row" >
			<ol class="breadcrumb">
				<li><a href="<%=path%>/QueryAssetInfoServ?page=1">库存管理</a></li>
				<li class="active">修改库存量</li>
			</ol>
			<form action="<%=path%>/UpdateMaterialNumberServ" method="POST" class="col-md-4 col-md-offset-4">
				<div class="form-group ">
				<label
						for="exampleInputEmail1">您正在修改的是<% 
								String id = request.getParameter("id");
								out.print(id);
						%>号仓库的库存量：</label> 
						<div hidden ><input type="input" class="form-control" id="exampleInputEmail1" placeholder="" name="id" value="<%=id%>"> </div>  
						<input type="input" class="form-control" id="exampleInputEmail1" placeholder="请输入您要修改的库存量的值" name="material_number">
</div>
				<button type="submit" class="btn btn-primary" style="background: #a94442" >修改</button>
				<a  class="btn btn-primary" style="background: #a94442" href="http://localhost:8080/factory-materials/WarehouseDataServ" >取消</a> 
			</form>
		</div>
	</div>
	<%@include file="../bottom.jsp"%>
</body>
<script src="<%=path%>/static/js/jquery.js"></script>
</html>