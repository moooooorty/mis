<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script>
	$("document").ready(function() {
		
		$("#btn01").click(function() {
			var name = $("#name").val();
			$.ajax({
				type : "GET",
				url : "GetUser",
				data : "para="+name,
				success : function(result) {
					var toJson = JSON.parse(result);
					$("#uid").val(toJson.id);
					$("#uname").val(toJson.name);
					$("#upwd").val(toJson.pwd);
					$("#udate").val(toJson.date);
					$("#uphone").val(toJson.phone);
				}
			});
		})
		$("#btn02").click(function(){
			var id = $("#uid").val();
			window.location.href="DeleteServlet?uid="+id;
		});
	});
</script>
</head>
<body>
	<h3>删除用户</h3>
	选择编号删除:
	<select name="" id="">
		<option value="">1</option>
		<option value="">2</option>
		<option value="">3</option>
		<option value="">4</option>
	</select>
	<br>
	<br> 输入用户名删除
	<input type="text" id="name">
	<button id="btn01">查找</button>
	<table>
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>注册日期</th>
			<th>手机号</th>
		</tr>
		<tr>
			<th><input type="text" id="uid" readonly></th>
			<th><input type="text" id="uname" readonly></th>
			<th><input type="text" id="upwd" readonly></th>
			<th><input type="text" id="udate" readonly></th>
			<th><input type="text" id="uphone" readonly></th>
		</tr>
	</table>
	<br>
	<button id="btn02">删除此用户</button>
</body>
</html>