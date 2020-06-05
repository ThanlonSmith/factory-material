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
		<div class="row">
		<%
					List<Warehouse> list3 = (List<Warehouse>) request.getAttribute("list");
					if (list3 == null || list3.size() < 1) {
						out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有任何库存信息！</td></tr>");
					} else {
						for (Warehouse v : list3) {
				%>
				<%
							if(Integer.parseInt(v.getMaterial_number())<100){
								%>
								<h3 style="weight:bold;color:red;">警告：目前存在仓库的库存量低于100，请及时补充物料！</h3>
								<%
								break;
							}
						}
					}
				%>
			<ol class="breadcrumb">
				<li><a href="<%=path%>/QueryAssetInfoServ?page=1">仓库信息管理</a></li>
				<li class="active">仓库信息查询</li>
			</ol>
			
			<div id="show" style="height:300px"></div>
			
			<br>
			
			<h4>列表显示库存量：</h4>
			<table class="table table-hover" style="text-align:center">
				<tr>
					<th style="text-align:center">仓库编号</th>
					<th style="text-align:center">物料数量</th>
					<th style="text-align:center">操作</th>
				</tr>
				<%
					List<Warehouse> list = (List<Warehouse>) request.getAttribute("list");
					if (list == null || list.size() < 1) {
						out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有任何资产信息！</td></tr>");
					} else {
						for (Warehouse v : list) {
				%>
				<tr>
					<td><%=v.getId()%>号</td>
					<td><%=v.getMaterial_number()%></td>
					<td><a
						href="<%=path%>/godownKeeper/editGodown.jsp?id=<%=v.getId()%>">修改</a>
						<a href="<%=path%>/DelGodownServ?id=<%=v.getId()%>"
						onclick="return confirm('确认删除仓库吗？请谨慎操作！')">&nbsp;&nbsp;删除</a></td>
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
<script src="<%=path%>/static/js/jquery.js"></script>
<script src="<%=path%>/static/js/echarts.js"></script>
<script>
var no_data = new Array();
var number_data = new Array();
<%
List<Warehouse> list2 = (List<Warehouse>) request.getAttribute("list");
for(int j=0;j<list2.size();j++)
{%>
//alert("<%=list2.get(j).getId()%>"); 
no_data[<%=j%>]="<%=list.get(j).getId()%>";
//alert("<%=list2.get(j).getMaterial_number()%>");
number_data[<%=j%>]="<%=list.get(j).getMaterial_number()%>";
<%
}
%>
//alert(no_data); 
var warehouse_info =  echarts.init(document.getElementById('show'), "");
var option = {
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
	            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    xAxis: {
	        type: 'category',
	        data: no_data
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{ 
	        name: '库存量', 
	        data: number_data,
	        type: 'bar',
	        barWidth: '60%'
	    }]
	};
warehouse_info.setOption(option)
</script>
<script>
function get_warehouse_data(){
	$.ajax({
	    url: "/WarehouseDataServ",
	    success: function (data) {
	         alert(data);
	        //ec_china_option.series[0].data = data.data;
	        chinaMap.setOption(ec_china_option)
	    }, error: function (xhr, type, errorThrow) {
	    }
	})
}
//setInterval(get_warehouse_data, 1000);
</script>
</html>