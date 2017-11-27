<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
 Page for View aspect of Java web app
 fullName and accounts passed in by RequestDispatcher of Login.java
 JSP file resides in WEB-INF because it must be secured by password
 -->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<%@ page import="irsDbase.control.Login" %>
		<title><% out.print(Login.TITLE); %></title>
	</head>
	<body>
		Hello, ${fullName}<p/>

 		<table>
			<tr>
				<th>First</th>
				<th>Last</th>
				<th>Username</th>
				<th>Income</th>
				<th>Paid</th>
			</tr>
			<c:forEach var="account" items="${accounts}">
			<tr>
				<td><c:out value="${account.first}"/></td>
				<td><c:out value="${account.last}"/></td>
				<td><c:out value="${account.username}"/></td>
				<td><c:out value="${account.income}"/></td>
				<td><c:out value="${account.paid}"/></td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>