<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Form</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsps/header.jsp"></jsp:include>
<br>
<br>
<br>
	<form method="POST" action="addContact.htm">
		<h2>
			<center>Contact Registration</center>
		</h2>

		<table width="100%" height="150" align="center" border="0">
			<tr>
				<td width="50%" align="right">ID</td>
				<td width="50%" align="left"><input type="text" name="id" size="30" /></td>
			</tr>
			<tr>
				<td width="50%" align="right">RollNo</td>
				<td width="50%" align="left"><input type="text" name="rollNo" size="30" /></td>
			</tr>
			<tr>
				<td width="50%" align="right">Address</td>
				<td width="50%" align="left"><input type="text" name="address" size="30" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"	value="Add Contact"></td>
			</tr>

		</table>

	</form>

</body>
</html>