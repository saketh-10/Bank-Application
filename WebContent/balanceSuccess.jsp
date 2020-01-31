<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your balance is</h1>
<%
session=request.getSession();
String balance=(String)session.getAttribute("balance");
out.println(balance);
%>
</body>
</html>