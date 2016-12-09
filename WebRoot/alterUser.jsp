<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script>
	$("document").ready(function() {
		var str = getStrDate();
		$("#udate").val(str);
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
	});
	function getStrDate(){
		var dt = new Date();
		var year = dt.getFullYear();
		var month = dt.getMonth()+1;
		var day = dt.getDate();
		if(day < 10 )
			day="0"+day;
		return year+"-"+month+"-"+day;
	}
</script>
</head>
<body>
	<h3>修改用户</h3>
	选择编号删除:
	<select name="" id="">
		<option value="">1</option>
		<option value="">2</option>
		<option value="">3</option>
		<option value="">4</option>
	</select>
	<br>
	<br> 输入用户名查找
	<input type="text" id="name">
	<button id="btn01">查找</button>
	<form action="AlterUserServlet" method="post">
	<table>
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>注册日期</th>
			<th>手机号</th>
		</tr>
		<tr>
			<th><input type="text" id="uid"  name="uid" readonly></th>
			<th><input type="text" id="uname" name="uname" ></th>
			<th><input type="text" id="upwd" name="upwd"></th>
			<th><input type="date" id="udate" name="udate"></th>
			<th><input type="text" id="uphone" name="uphone"></th>
		</tr>
	</table>
	<br>
	<input type="submit" value="提交修改">
	</form>
</body>
</html>