<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html>
<head><title>Spring 4 Security Example</title></head>
<body>
  <h3>Spring 4 Security Example </h3>
  <form:form action="result" method="POST" commandName="student">
    <form:input  path="stdId"/> <br/>
    <input type="submit" value="Submit">
  </form:form>
</body>
</html>