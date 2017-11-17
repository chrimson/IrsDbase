<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
 First welcome page is JSP, dictated by WEB-INF/web.xml
 -->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>IRS Database</title>
	</head>
	<body>
		<form action="Login" method="POST">
			Username <input type="text" name="user"/><br/>
			Password <input type="password" name="pass"/><br/>
			<input type="submit" value="Login"/>
		</form>
	</body>
</html>