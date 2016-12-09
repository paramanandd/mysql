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
<%String user=(String)request.getSession().getAttribute("user");
out.println("welcome : "+user); 

%>
			<h3>
			<a href='17_SearchbookDetails.jsp'>Search Book</a><br>
			<a href='21_ShowReviewDetails.jsp'>Show Review</a><br>
			<a href='19_AddReviewDetails.jsp'>Add Review</a>
			</h3>
</body>
</html>