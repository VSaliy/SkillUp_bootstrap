<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Address</th>
		</tr>
		<tr>
			<th>${mycontact.firstName }</th>
			<th>${mycontact.lastName }</th>
			<th>${mycontact.gender }</th>
			<th>${mycontact.phone_number }</th>
			<th>${mycontact.email }</th>
			<th>${mycontact.address }</th>
		</tr>
	</table>
</center>
</body>
</html>