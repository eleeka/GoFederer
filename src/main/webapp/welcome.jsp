<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome </title>
</head>
<body>
 <h3>City Description is</h3>  
     
        <textarea name='test' id='test'><%=session.getAttribute("name")%> </textarea>
         
</body>
</html>