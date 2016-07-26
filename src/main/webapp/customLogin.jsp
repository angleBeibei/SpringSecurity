<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Spring 4 Security Example</title>
    </head>
    <body>
       <h3>Spring 4 Security Example</h3>
        <font color="red">
        <c:if test="${param.failed==true }">
           <spring:message code="login.failed_message"/>
           <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
		   		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
		   </c:if>
		</c:if>
        </font>
	<form action="<%=request.getContextPath()%>/appLogin" method="POST">
		Enter UserName:	<input type="text" name="app_username"/><br/><br/>
		Enter Password: <input type="password" name="app_password"/> <br/><br/>			
		<input type="submit" value="Login"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>			
	</form>
    <body>
</html>   
