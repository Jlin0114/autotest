<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<title>首页</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#submit").click(function() {
			//序列化表单元素，返回json数据 
			var params = $("#creatAudit").serializeArray();
			//console.log(params);
			//也可以把表单之外的元素按照name value的格式存进来 
			//params.push({name:"hello",value:"man"}); 
			$.ajax({
				type : "post",
				url : "creatAudit",
				data : params,
				success : function(result) {
					alert("12345");
					alert(result.message);
				}
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
	<form id="creatAudit">
		<span>设备号</span> <input name=deviceNo type="text" />
		<button id="submit">设备上传出入库信息</button>
	</form>
</body>
</html>