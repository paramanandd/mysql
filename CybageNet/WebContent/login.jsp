<%@page import="com.cybage.bean.Login"%>
<%@page import="com.cybage.dao.LoginDao"%>
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
<h1>Welcome To CybageNet</h1>

<%! public static int count = 0; %>
<%

String uname=request.getParameter("uname");
String pswd=request.getParameter("password");
LoginDao ld=new LoginDao();
Login lgn=new Login(uname,pswd); 
String role=ld.validate(lgn);
if(role.equals("admin"))
{
	response.sendRedirect("11_WelcomeAdmin.jsp");
}
else if(role.equals("user") )
{
	response.sendRedirect("16_WelcomeUser.jsp");
	request.getSession().setAttribute("user", uname);
	count=count+1;
	request.getSession().setAttribute("count", count);
}
else
{
	response.sendRedirect("index.jsp");
}
%>
</body>
</html>