<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 29/05/2021
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Utworzona osoba</title>
</head>
<body>
<table>
    <tr>
        <th>Lp.</th>
        <th>Id</th>
        <th>Login</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    <tr>
        <td>1.</td>
        <td>${person.id}</td>
        <td>${person.login}</td>
        <td>${person.email}</td>
        <td>${person.password}</td>
    </tr>
</table>

</body>
</html>
