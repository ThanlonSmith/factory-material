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
			<a class="navbar-brand" href="" style="color: white">山东锦城工业有限公司物料申请平台</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
						<li><a href="<%=path%>/user/index.jsp" style="color: white;"
						id="nav-1">首页<span class="sr-only">(current)</span></a></li>
					<!--  
					<li><a href="<%=path%>/user/apply.jsp" style="color: white" id="nav-3">物料申请</a></li>
					
					<li><a href="<%=path%>/user/apply_info.jsp" style="color: white" id="nav-3">申请记录</a></li>
					-->
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
					String username = (String) session.getAttribute("username");
				if (username == null || "".equals(username)) {
					response.sendRedirect("" + path + "+/user/user_login.jsp");
				} else {
				%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" style="color: white"> <%=username%> <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="<%=path%>/UserSignOutServ"
							onclick="return confirm('确认退出系统？')">退出系统</a></li>
					</ul></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</nav>