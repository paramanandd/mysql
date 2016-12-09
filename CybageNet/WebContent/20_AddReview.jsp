<%@page import="com.cybage.dao.BookDao"%>
<%@page import="com.cybage.bean.Review"%>
<%@page import="com.cybage.dao.ReviewDao"%>
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
<h1>Welcome To CybageNet</h1><h6><a href='index.jsp'>Logout</a></h6>
<h3>
<%
String bkname=request.getParameter("bookname");
String review=request.getParameter("review");
String user=(String)request.getSession().getAttribute("user");
ReviewDao rdao=new ReviewDao();
Review rev=new Review(review, bkname, user);
BookDao bdao= new BookDao();
if((bdao.search(bkname)).getBookname()!=null)
	{
	int res=rdao.insertreview(rev);
	out.println("review inserted successfully");
	}
else
	{
	out.println("Soory.... You Made Wrong Choices");
	}
%>
</h3>
</body>
</html>