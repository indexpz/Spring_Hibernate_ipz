<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 29/05/2021
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Utwórz Studenta</title>
</head>
<body>
<form:form method="POST" action="" modelAttribute="student">
    <div><label>Imię: <form:input path="firstName"/></label></div>
    <div><label>Naswisko: <form:input path="lastName"/></label></div>
    <div><label>Płeć:</label></div>
    <div><label>Mężczyzna <form:radiobutton path="gender" value="M"/></label></div>
    <div><label>Kobieta <form:radiobutton path="gender" value="K"/></label></div>
    <div><label>Państwo:<form:select path="country" items="${countries}"/> </label></div>
    <div><label>Notes:<form:textarea path="notes" rows="4" cols="25"/></label></div>
    <div><label>Lista mailingowa:<form:checkbox path="mailingList"/></label></div>
    <div><label>Umiejętności programistyczne:<form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/></label></div>
    <div><label>Hobby: <form:checkboxes path="hobbies" items="${hobbies}"/></label></div>
    <div><form:button type="submit">Dodaj</form:button></div>
</form:form>

</body>
</html>
