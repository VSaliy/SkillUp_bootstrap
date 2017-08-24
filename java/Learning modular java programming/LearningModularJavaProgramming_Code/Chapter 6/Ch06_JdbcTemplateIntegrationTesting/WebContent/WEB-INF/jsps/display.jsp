<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsps/header.jsp"></jsp:include>
<br>
<br>
<br>
	<h1 align="center">Contact List</h1>
	<table align="center" border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone Number</th>
		</tr>
			<tr>
				<td><c:out value="${ contact.firstName }"></c:out></td>
				<td><c:out value="${ contact.lastName }"></c:out></td>
				<td><c:out value="${ contact.email }"></c:out></td>
				<td><c:out value="${ contact.phone_number }"></c:out></td>
			</tr>
	</table>
</body>
</html>