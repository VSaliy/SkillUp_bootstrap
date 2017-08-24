<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="er" value="${param.error }"></c:set>
	<c:if test="${ er.equals('error')}">
		<c:out value="please provide correct credentials"></c:out>
	</c:if>

	<c:if test="${ not empty msg }">
		<c:out value="${msg}"></c:out>
	</c:if>

	<form action="<c:url value='/j_spring_security_check'/>" method="post">
		<table>
			<tr>
				<td>USER:</td>
				<td><input type="text" name="j_username" value=""></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="username" value="LOGIN"></td>
			</tr>

		</table>
	</form>
</body>
</html>