<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="false"%>
<html>
    <head>
        <title>Spring 4 Security Example</title>
    </head>
    <body>
      Welcome! To get student detail <a href="<%=request.getContextPath()%>/secure/studentDetail">click here.</a>
      <form action="<%=request.getContextPath()%>/appLogout" method="POST">
        <input type="submit" value="Logout"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
      </form>      
    </body>
</html> 