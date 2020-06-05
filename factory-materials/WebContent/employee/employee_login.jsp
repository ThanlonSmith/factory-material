<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工登录</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style>
#bg {
	margin: 0px;
	background:
		url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589055429441&di=e43714af3431bab23ae29ca0a6756265&imgtype=0&src=http%3A%2F%2Fimgwww.heiguang.net%2Fuploadfile%2F2015%2F0105%2F20150105045559721.jpg")
		no-repeat;
	background-size: 100% 100%;
	background-attachment: fixed;
}
</style>
</head>
<body id="bg">
	<div class="container">
		<div class="row" style="margin-top: 80px">
			<div class="col-md-4 col-md-offset-4">
				<h2 class="text-center">工厂物料管理系统</h2>
				<br>
				<div class="panel panel-primary" style="border-color: #a94442">
					<div class="panel-heading" style="background: #a94442">
						<span class="glyphicon glyphicon-user"></span>员工登录
					</div>
					<div class="panel-body">
						<form action="<%=path%>/EmpLoginServ" method="POST" name="loginForm">
							<div class="form-group">
								<label for="name">用户名</label> <input type="text"
									class="form-control" name="name" placeholder="请输入用户名"
									autofocus="autofocus" maxlength="15">
							</div>
							<div class="form-group">
								<label for="">密码</label> <input type="password"
									class="form-control" name="pwd" placeholder="请输入密码"
									maxlength="20">
							</div>
							<button type="reset" class="btn btn-primary"
								style="background: #a94442">重置</button>
							<button type="submit" class="btn btn-primary"
								onclick="return checkForm()" style="background: #a94442">登录</button>
								<a href="/factory-materials/" style="color:green;font-weight:bold">重新选择角色!</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	function checkForm() {
		var name = $.trim(loginForm.name.value);
		var pwd = $.trim(loginForm.pwd.value);
		if (name == "" || name == null) {
			alert("请输入用户名");
			loginForm.name.focus();
			return false;
		} else if (pwd == "" || pwd == null) {
			alert("请输入密码");
			loginForm.pwd.focus();
			return false;
		} else if (pwd.length < 6) {
			alert("密码至少需要6位");
			loginForm.pwd.focus();
			return false;
		}
		return true;
	}
</script>
</html>