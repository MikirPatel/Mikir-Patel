<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>
<h1 align = "center">List ALL Detail</h1>

<table align = "center" border = "1">
	<tr>
		<th>Id</th>
		<th>Email</th>
		<th>UserName</th>
		<th>Password</th>
		<th>DELETE</th>
		<th>UPDATE</th>
	</tr>

		<c:set var = "a" value = "0"/>
		<c:forEach items="${listall}" var = "data">
			<tr>
				<td><c:out value = "${a = a + 1}"/></td>
				<td><c:out value = "${data.email}"/></td>
				<td><c:out value = "${data.uname}"/></td>
				<td><c:out value = "${data.password}"/></td>
				<td><a href = "regDetail?flag=RegDelete&id=${data.id}">DELETE</a></td>
				<td><a href = "regDetail?flag=updatereg&id=${data.id}">UPDATE</a></td>
			</tr>
		</c:forEach>
		
</table>
	<tr>
			<td>
			<a href = "InsertReg.jsp">Insert</a>
			</td>
		</tr>
</body>
</html>