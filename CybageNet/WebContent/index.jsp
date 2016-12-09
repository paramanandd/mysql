<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
<%
session.invalidate();
%>

<h1>Welcome To CybageNet</h1>
<h3>
<form action="login.jsp" method="post">
User Name  <input type="text" name="uname" required="required"><br>
Password   <input type="password" name="password" required="required"><br>
<input type="submit" value="Login">
</form>
</h3>

</body>
</html>