<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>menu</title>
<link rel="stylesheet" href="css/base.css" type="text/css" />
<link rel="stylesheet" href="css/menu.css" type="text/css" />

<script language="javascript" type="text/javascript"
	src="js/frame/menu.js"></script>
<script language='javascript'>
	var curopenItem = '1';
</script>
<base target="main" />
</head>
<body>
	<table width='99%' height="100%" border='0' cellspacing='0'
		cellpadding='0'>
		<tr>
			<td style='padding-left: 3px; padding-top: 8px' valign="top">
				<!-- Item 1 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items1_1")'>
						<b>登录与注册模块</b>
					</dt>
					<dd style='display: block' class='sitem' id='items1_1'>
						<ul class='sitemu'>
							<li><a href='ShowUsers' target='main'>&nbsp;查看已注册用户 <img
									src='img/frame/gtk-sadd.png' alt='创建栏目' title='创建栏目' />
							</a></li>
							<li><a href='deleteUser.jsp' target='main'>&nbsp;删除用户 <img
									src='img/frame/gtk-del.png' alt='删除用户' title='删除用户' />
							</a></li>
							<li><a href='alterUser.jsp' target='main'>&nbsp;修改用户 <img
									src='img/frame/gtk-sadd.png' alt='修改用户' title='修改用户' />
							</a></li>
							<li><a href='usersServlet.action?method=listUsers'>&nbsp;AAAAAA
									<img src='img/frame/gtk-sadd.png' alt='创建栏目' title='创建栏目' />
							</a></li>
							<li><a href="javascript:void(0);">&nbsp;【适应待开发】 <img
									src='img/frame/gtk-sadd.png' alt='未来增项' title='未来增项' />
							</a></li>
						</ul>
					</dd>
				</dl> <!-- Item 1 End -->
				<dl class='bitem'>
					<dt onClick='showHide("items2_2")'>
						<b>oracle管理系统</b>
					</dt>
					<dd style='display: block' class='sitem' id='items2_2'>
						<ul class='sitemu'>
							<li><a href='javascript:void(0);' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='javascript:void(0);' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='javascript:void(0);' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='javascript:void(0);' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='javascript:void(0);' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='ShowEmps' target='main'>&nbsp;【多表查询雇员】<img
									src='img/frame/arr3.gif' /></a></li>
						</ul>
					</dd>
				</dl> <!-- Item 2 Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items3_3")'>
						<b>日志管理模块</b>
					</dt>
					<dd style='display: block' class='sitem' id='items3_3'>
						<ul class='sitemu'>
							<li><a href='#' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='#' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='#' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='#' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='#' target='main'>&nbsp;AAAAAA<img
									src='img/frame/arr3.gif' /></a></li>
							<li><a href='#' target='_blank'>&nbsp;&nbsp;&nbsp;官方网站</a></li>
							<li><a href='#/' target='_blank'>&nbsp;更多后台模板</a></li>
						</ul>
					</dd>
				</dl> <!-- Item 2 End -->
			</td>
		</tr>
	</table>
</body>
</html>