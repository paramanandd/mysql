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
		<form action='20_AddReview.jsp' method="post">
		<input type='text' name='bookname' placeholder='enter book name' required="required">
		<input type='text' name='review' placeholder='Write review' required="required"><br>
		<input type='submit' value='Add Review'>
		</form>
	</h3>
</body>
</html>