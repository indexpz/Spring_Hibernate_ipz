<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 29/05/2021
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Utwórz książkę</title>
</head>
<body>
<form:form method="POST" action="" modelAttribute="book">
    <label>Tytuł:
    <form:input path="title"/></label><br/>
    <label>Rating:
    <form:input path="rating" type="number" min="1" max="9" step="1"/><br/></label>
    <label>Description:
        <form:textarea path="description" rows="4" cols="10"/><br/>
    </label>
    <label>Autorzy:
        <form:select path="authors" items="${allAuthors}" itemLabel="fullName" itemValue="id" multiple="true"/><br/> </label>
    <label>Wydawca:
    <form:select path="publisher" items="${allPublishers}" itemLabel="name" itemValue="id"/><br/> </label>
    <form:button type="submit">Dodaj</form:button>
</form:form>
</body>
</html>
