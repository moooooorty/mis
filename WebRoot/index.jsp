<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内容管理系统</title>
<style>
body {
	scrollbar-base-color: #C0D586;
	scrollbar-arrow-color: #FFFFFF;
	scrollbar-shadow-color: DEEFC6;
}
</style>
</head>
<!--
    	web框架(frameset与frame): 实现窗口的分割。
    	注意: 使用时，本页面不能有<body></body>标签。
    	frameset属性: rows, cols, frameborder, border, framespacing(在IE中观察明显) 
    	frame属性: name, src, scrolling, noresize 
    -->
<frameset rows="60,*" cols="*" frameborder="yes" border="1"
	framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="no">
	<frameset cols="170,*" name="btFrame" frameborder="yes" border="1"
		framespacing="0">
		<frame src="menu.jsp" noresize name="menu" scrolling="yes">
		<frame src="main.jsp" noresize name="main" scrolling="yes">
	</frameset>
</frameset>
<noframes>
	<body>您的浏览器不支持框架！
	</body>
</noframes>
</html>