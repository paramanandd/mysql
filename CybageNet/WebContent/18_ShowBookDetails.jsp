<%@page import="com.cybage.dao.BookDao"%>
<%@page import="com.cybage.bean.Book"%>
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
		BookDao searchdao=new BookDao();
		Book bookInstance=searchdao.search(bkname);
		if(bookInstance.getBookname() !=null)
		{
	%>
		 
		 <table border="2" align="center">
		 <tr><td>NAME</td><td>Author</td><td>Price</td>	</tr>
		 <tr><td><%out.println(bookInstance.getBookname()); %></td>
  		 <td><%out.println(bookInstance.getAuthor()); %></td>
   		 <td><%out.println(bookInstance.getPrice()); %></td></tr>
   		 </table> </h3>	
	<%
		}
		else
		{
			out.println("No such book available ");
		}
	%>
		
</body>
</html>