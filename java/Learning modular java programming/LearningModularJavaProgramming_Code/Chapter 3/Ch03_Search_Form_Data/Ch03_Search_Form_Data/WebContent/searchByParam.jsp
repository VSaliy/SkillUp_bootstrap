<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsps/header.jsp"></jsp:include>
	<center>
		<h1>Please Enter Id to Search</h1>
	</center>
	<table align="center">
		<form action="searchFromRequest.htm">
			<tr>
				<td>Enter ID:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</form>
	</table>
</body>
</html>