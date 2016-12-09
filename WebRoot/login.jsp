<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
<script src="js/jquery-1.7.2.min.js"></script>
<script>
	$(document).ready(function() {
		var name = false;
		var pwd = false;
		$("#uname").blur(function() {
			if (this.value.trim() == "")
				alert("用户名不能为空");
			name = true;
		});
		$("#pwd").blur(function() {
			if (this.value == "")
				alert("用户名不能为空");
			pwd = true;
		});
		$("#id").click(function() {
			return name && pwd;
		});
	});
</script>

</head>
<body>
	<form action="HandleLogin" method="post">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td bgcolor="#e5f6cf">&nbsp;</td>
			</tr>
			<tr>
				<td height="608" background="img/login_03.gif">
					<table width="862" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="266" background="img/login_04.gif">&nbsp;</td>
						</tr>
						<tr>
							<td height="95">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="424" height="95" background="img/login_06.gif">&nbsp;</td>
										<td width="183" background="img/login_07.gif">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="21%" height="30"><div align="center">
															<span>用户</span>
														</div></td>
													<td width="79%" height="30"><input type="text"
														name="uname" id="uname" placeholder="用户名"
														style="height: 18px; width: 130px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;"></td>
												</tr>
												<tr>
													<td height="30"><div align="center">
															<span>密码</span>
														</div></td>
													<td height="30"><input type="password" name="pwd"
														id="pwd" placeholder="密码"
														style="height: 18px; width: 130px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;"></td>
												</tr>
												<tr>
													<td height="30">&nbsp;</td>
													<td height="30"><input type="submit" id="sb"
														value="登  陆" />&nbsp; <a href="register.html"><input
															type="button" value="注  册" /></a></td>
												</tr>
											</table>
										</td>
										<td width="255" background="img/login_08.gif">&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="247" valign="top" background="img/login_09.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="22%" height="30">&nbsp;</td>
										<td width="56%">&nbsp;</td>
										<td width="22%">&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td height="30">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="44%" height="20">&nbsp;</td>
													<td width="56%">版本 2016V1.6</td>
												</tr>
											</table>
										</td>
										<td>&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td bgcolor="#a2d962">&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>