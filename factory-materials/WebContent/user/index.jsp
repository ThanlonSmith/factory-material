<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%
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
<title>用户物料申请-山东金成工业有限公司物料申请</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
<body style="margin-top: 65px">
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="row">
			<ol class="breadcrumb"> 
			<li class="active">物料申请</li>
				<!-- <li class="active">申请记录</li> -->
			</ol>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form action="<%=path%>/InsertMaterialApply" method="POST" name="loginForm">
					<div class="form-group">
						<label for="exampleInputEmail1">物料名称</label> <input type="input"
							class="form-control" id="exampleInputEmail1" placeholder="物料名称" name="name">
					</div>
					<div class="form-group"  hidden>
						<label for="exampleInputEmail1">申请人</label> <input type="input"
							class="form-control" id="exampleInputEmail1"
							placeholder="申请人" value="<%=username%>" name="applicant">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">收获地址</label> <input
							type="input" class="form-control" id="exampleInputPassword1"
							placeholder="收获地址" name="address">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">联系电话</label> <input
							type="input" class="form-control" id="exampleInputPassword1"
							placeholder="联系电话" name="mobile_nubmer"> 
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">备注</label> <input
							type="input" class="form-control" id="exampleInputPassword1"
							placeholder="备注" name="others">
					</div>
					<button type="submit" class="btn btn-primary" style="background:#a84442">提交订单</button>
				</form>
			</div>
		</div>
	</div>
	<%@include file="../bottom.jsp"%>
</body> 
</html>