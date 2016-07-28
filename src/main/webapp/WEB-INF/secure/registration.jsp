<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
</head>
<body>
	<form:form method="POST" modelAttribute="userForm" enctype="utf8">
		<table>
			<tr>
				<td>username:</td>
				<td>
					<spring:bind path="username">
					<form:input path="username"></form:input>
					<form:errors path="username"></form:errors>
					</spring:bind>
				</td>
			</tr>
			<tr>
				<td>password:</td>
				<td>
					<spring:bind path="password">
					<form:input path="password"></form:input>
					<form:errors path="password"></form:errors>
					</spring:bind>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="registe"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>