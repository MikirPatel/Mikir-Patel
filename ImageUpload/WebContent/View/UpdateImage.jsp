<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Image</title>
</head>
<body>

		<form align = "center" method = "post" action = "ImageController" enctype="multipart/form-data">

			<c:forEach items="${UpdateImage}" var="userdata">
				<input type = "hidden" name = "id" value = "${userdata.id}"/>
			</c:forEach>
			Image Upload: <input type = "file" name = "image"/><br>
			<input type = "submit" value = "Upload"/>
			
			<input type = "hidden" name = "flag" value = "UpdateImageData"/><br>
			
<%-- 			<a href = "<%= request.getContextPath()%>/ImageController?flag=ListAllImage">Show All Image</a> --%>
	</form>
	

</body>
</html>