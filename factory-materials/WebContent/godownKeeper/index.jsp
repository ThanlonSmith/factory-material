<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%
	String username = (String) session.getAttribute("godownKeeper");
	//System.out.print(admin);
	if (username == null || "".equals(username)) {
		response.sendRedirect("" + path + "/godownKeeper/godownKeeper_login.jsp"); 
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
				<li><a href="<%=path%>/QueryAssetInfoServ?page=1">首页</a></li>
				<li class="active">欢迎界面</li>
		
			</ol>
			<h4>欢迎使用本系统!</h4>
			<h4>
				当前时间：<span id="show"></span>
			</h4>
		</div>
	</div>
	<%@include file="../bottom.jsp"%>
</body>
<script type="text/javascript">
	function showTime() {
	       var nowTime = new Date();
	　　　　var years = nowTime.getFullYear();
	　　　　var mouths = nowTime.getMonth();
	　　　　var days = nowTime.getDate();
	　　　　var hours = nowTime.getHours();
	　　　　var minites = nowTime.getMinutes();
	　　　　var seconds = nowTime.getSeconds();
	　　　　var time = years+"年";
	　　　　time += (mouths+1)+"月"+days+"日";
	　　　　time += (hours<10?"0":"")+hours;
	　　　　time += (minites<10?":0":":") + minites;
	　　　　time += (seconds<10?":0":":") + seconds;
	　　　　time += (hours>12)?"PM":"AM";
	　　　　document.getElementById("show").innerHTML = time;
	　　　　setTimeout("showTime()",1000);
	};
	showTime();
</script>
</html>