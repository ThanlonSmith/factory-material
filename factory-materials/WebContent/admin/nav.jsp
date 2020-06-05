<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<nav class="navbar navbar-default navbar-fixed-top"
	style="background: #a94442">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="" style="color: white">工厂物料管理系统</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<%=path%>/admin/index.jsp" style="color: white;"
					id="nav-1">首页<span class="sr-only">(current)</span></a></li>
				<li><a href="<%=path%>/GodownKeeperInfoServ"
					style="color: white" id="nav-2">仓库管理员信息管理</a></li>
				<li><a href="<%=path%>/EmployeeInfoServ" style="color: white"
					id="nav-3">员工(接单员)信息管理</a></li>
				<li><a href="<%=path%>/DepartmentInfoServ"
					style="color: white" id="nav-3">部门信息管理</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
					String admin = (String) session.getAttribute("admin");
				if (admin == null || "".equals(admin)) {
					response.sendRedirect("" + path + "+/admin/admin_login.jsp");
				} else {
				%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" style="color: white"> <%=admin%> <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="<%=path%>/SignOutServ"
							onclick="return confirm('确认退出系统？')">退出系统</a></li>
					</ul></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</nav>