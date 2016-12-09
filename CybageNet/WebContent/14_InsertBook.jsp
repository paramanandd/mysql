<%@page import="com.cybage.dao.BookDao"%>
<%@page import="com.cybage.bean.Book"%>
<%@page import="com.cybage.connection.MyConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%-- <<jsp:useBean id=""></jsp:useBean> --%>
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
String bookName=request.getParameter("t1");
String bookAuthor=request.getParameter("t2");
int bookPrice=Integer.parseInt(request.getParameter("t3"));


Book bk=new Book(bookName,bookAuthor,bookPrice);
BookDao bkdao=new BookDao();

if(bkdao.insert(bk)==1)
{
	out.println("Book Inserted Successfully");
}
else
	out.println("sorry wrong entries");
%>
</h3>
</body>
</html>