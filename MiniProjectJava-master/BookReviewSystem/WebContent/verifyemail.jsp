<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String email=request.getParameter("val"); %>

<%
	try
	{  
		int count=0;
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");  
 		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from emp where empemail='"+email+"'");  
		while(rs.next())
		{
			count=rs.getInt(1);
		}
		if(count!=0)
		{
			
			out.println("Email is already exist");
			
		}
		else
		{
			out.println("");
		}
		con.close();  
	}
	catch(Exception e)
	{ 
		System.out.println(e);
	}  
  
%>
</body>
</html>