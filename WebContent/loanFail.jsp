<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession();
String name=(String)session.getAttribute("name");
String email=(String)session.getAttribute("email");
out.println("Dear"+" "+name+" "+"you are not eligible for applying the loan...!Please try again");
%>
</body>
</html>