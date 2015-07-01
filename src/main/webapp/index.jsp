<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City Description</title>
</head>
<body>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/citydescription";%>
<%!String user = "root";%>
<%!String psw = "july";%>
<form action="loginServlet" method ="post">
<%
Connection con = null;
PreparedStatement ps = null;
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql = "SELECT * FROM cide";
ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery(); 
%>
<center>
<p>Select City name here :
<select name="cityname">
<%
while(rs.next())
{
//String fname = rs.getString("firstname"); 
%>
<option><%= rs.getString(2)%></option>
<%
}
%>
</select>
</p>
<%
}
catch(SQLException sqe)
{ 
out.println(sqe);
}
%>
<input type="submit" value="submit" />
</center>
</form></body>
</html>