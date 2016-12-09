<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<script>  
function validateform(){  
var name=document.myform.t1.value;  
var author=document.myform.t2.value;  
var price=document.myform.t3.value;  

if (name==null || name==""){  
  alert("Name can't be blank");  
  return false;  
}else if(author==null || author==""){  
  alert("author can't be blank");  
  return false;  
  }  
else if(price==null || price==""){  
	  alert("price can't be blank");  
	  return false;  
	  }  
}  
</script>
<body>
<h1>Welcome To CybageNet</h1>
<h6><a href='index.jsp'>Logout</a></h6>
	<h3>
		<form name="myform" action='14_InsertBook.jsp'  onsubmit="return validateform()"> 
				Book Name<input type='text' name='t1'><br>
				Book Author<input type='text' name='t2' ><br>
				Book Price<input type='text' name='t3' ><br>
				<input type='submit' value='Add Book'>
		</form>
	</h3>
</body>
</html>