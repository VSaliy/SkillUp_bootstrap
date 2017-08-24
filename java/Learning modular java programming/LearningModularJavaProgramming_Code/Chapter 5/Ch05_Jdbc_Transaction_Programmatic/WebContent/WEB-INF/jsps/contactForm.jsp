<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Form</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsps/header.jsp"></jsp:include>
	<br>
	<br>
	<form:form modelAttribute="contact" method="POST"
		action="addContact.htm">
		<h2>
			<center>Contact Registration</center>
		</h2>

		<table width="100%" height="150" align="center" border="0">
			<tr>
				<td width="50%" align="right">FIRST NAME</td>
				<td width="50%" align="left"><form:input path="firstName"
						size="30" /> <font color="red"><form:errors
							path="firstName" /></font></td>
			</tr>
			<tr>
				<td width="50%" align="right">LAST NAME</td>
				<td width="50%" align="left"><form:input path="lastName"
						size="30" /> <font color="red"><form:errors
							path="lastName" /></font></td>
			</tr>
			<tr>
				<td width="50%" align="right">GENDER</td>
				<td width="50%" align="left"><form:select path="gender">
						<form:options items="${genderList}" itemValue="id"
							itemLabel="value" />
					</form:select> <font color="red"><form:errors path="gender" /></font></td>
			</tr>
			<tr>
				<td width="50%" align="right">ADDRESS</td>
				<td width="50%" align="left"><form:input path="address"
						size="30" /> <font color="red"><form:errors path="address" /></font>
				</td>
			</tr>
			<tr>
				<td width="50%" align="right">PHONE NUMBER</td>
				<td width="50%" align="left"><form:input path="phone_number"
						size="30" /> <font color="red"><form:errors
							path="phone_number" /></font></td>
			</tr>

			<tr>
				<td width="50%" align="right">EMAIL</td>
				<td width="50%" align="left"><form:input path="email" size="30" />
					<font color="red"><form:errors path="email" /></font></td>
					
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add Contact"></td>
			</tr>
			<tr>
				<td width="50%" align="right"></td>
				<td width="50%" align="left" style="font: bold; color: red; size: 20px;">${error}</td>
			</tr>

		</table>

	</form:form>

</body>
</html>