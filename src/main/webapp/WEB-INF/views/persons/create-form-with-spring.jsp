<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 29/05/2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Utwórz osobę with spring</title>
</head>
<body>
<form:form method="POST" action="" modelAttribute="person">
    <div>
        <label>Login: <form:input type="text" path="login" value=""/></label>
    </div>
    <div>
        <label>Email: <form:input type="email" path="email" value=""/></label>
    </div>
    <div>
        <label>Password: <form:password path="password" value=""/></label>
    </div>
    <div><button type="submit">Dodaj</button> </div>
</form:form>
</body>
</html>
