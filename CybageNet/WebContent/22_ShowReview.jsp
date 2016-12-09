<%@page import="java.util.ArrayList"%>
<%@page import="com.cybage.bean.Review"%>
<%@page import="com.cybage.bean.Book"%>
<%@page import="com.cybage.dao.ReviewDao"%>
<%@page import="com.cybage.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
		String book=request.getParameter("bookname");	
		BookDao bdao=new BookDao();
		ReviewDao rdao=new ReviewDao();
		Book bookInstance=bdao.search(book);
		ArrayList<String> rlist=rdao.search(book);
		if(bookInstance.getBookname() !=null)
		{
		%>
		
			 <table border="2" align="center">
			 <tr><td>NAME</td><td>Author</td><td>Price</td>	</tr>
		 	 <tr><td><%out.println(bookInstance.getBookname()); %></td>
   			 <td><%out.println(bookInstance.getAuthor()); %></td>
    		 <td><%out.println(bookInstance.getPrice()); %></td></tr>
    		 </table>
    		 Reviews
		<%	for (int i=0;i<rlist.size();i++){
			out.println("<br>");	
			out.println(rlist.get(i));
		} 	
		}
		else
			out.println("No such book available");
	%></h3>
	<c:forEach var="window" items="${rlist}">
    <c:out value="${window}"/> 
	</c:forEach>

</body>
</html>