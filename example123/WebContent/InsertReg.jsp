<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body>
<h1 align = "center">Insert Reg. Detail</h1>

<form action = "regDetail" method = "post">
	<input type = "hidden" value = "RegInsert" name ="flag"/>
	<table align = "center">
		<tr>
			<td>Email:</td>
			<td><input type = "text" name ="email"/></td>
		</tr>
		<tr>
			<td>User Name:</td>
			<td><input type = "text" name ="uname"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type = "password" name ="pass"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type = "submit" value ="OK"/></td>
		</tr>
		<tr>
			<td>
			<a href = "regDetail?flag=listall">List All</a>
			</td>
		</tr>
	</table>
	
</form>

</body>
</html>