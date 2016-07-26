<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Spring 4 Security Example</title>
    </head>
    <body>
          <h3>Spring 4 Security Example</h3>
          Student Name:  ${stdName}
	  <form action="<%=request.getContextPath()%>/appLogout" method="POST">
	     <input type="submit" value="Logout"/>
	     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
	  </form>
    </body>
</html> 