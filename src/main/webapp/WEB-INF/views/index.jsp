<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<link rel="shortcut icon" href="#" />

	
<title>首页</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reportIn").click(function() {
			$.ajax({
				type : "post",
				url : "reportIn",
				data : {"deviceNo":$("#deviceNo").val()},
				dataType:"json",
				success : function(data) {
					var message = data.message;
					alert(message);
					$("#serialId").val($("#serialId").val()+","+data.serialId);
					
				},
				error : function(data) {
					var message = data.message;
					alert(message);
					
				},
			});
		});
		
		$("#reportOut").click(function() {
			$.ajax({
				type : "post",
				url : "reportOut",
				data : {"deviceNo":$("#deviceNo").val(),"serialId":$("#serialId1").val()},
				dataType:"json",
				success : function(data) {
					var message = data.message;
					alert(message);
					
				},
				error : function(data) {
					var message = data.message;
					alert(message);
					
				},
			});
		});
		
		
	});
</script>
<style>
body {
	background-image: url("/static/img/1.jpg");
}
</style>
<body>
	<form id="report">
		<span>设备号</span> <input id=deviceNo  type="text" />
		<select>
  			<option value ="volvo">测试环境</option>
  			<option value ="saab">预生产环境</option>
		</select>
		<button id="reportIn" type="button">入库</button>
		<span>serialId</span><textarea id=serialId cols="10" rows="1"></textarea><br/>
		<span>出库serialId</span><input id=serialId1  type="text" />
		<button id="reportOut" type="button">出库</button>
	</form>
</body>
</html>