<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 29/05/2021
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Utworzony Student</title>
</head>
<body>
<table>
    <tr>
        <th>Lp.</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>gender</th>
        <th>country</th>
        <th>notes</th>
        <th>mailingList</th>
        <th>programmingSkills</th>
        <th>hobbies</th>
    </tr>
    <tr>
        <td>1.</td>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.gender}</td>
        <td>${student.country}</td>
        <td>${student.notes}</td>
        <td>${student.mailingList}</td>
        <td>${student.programmingSkills}</td>
        <td>${student.hobbies}</td>
    </tr>
</table>
</body>
</html>








