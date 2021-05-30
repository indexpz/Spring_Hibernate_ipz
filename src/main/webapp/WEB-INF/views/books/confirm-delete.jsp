<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 30/05/2021
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuń książkę</title>
</head>
<body>
<div>
    <form method="post" action="">
    <table>
        <p>czy usunąć książkę:</p>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Rating</th>
            <th>Description</th>
            <th>Publisher</th>
        </tr>

            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.description}</td>
                <td>${book.publisher.name}</td>
                <input type="hidden" name="id" value="${book.id}"/>
                <td><a href="/forms/book/list"><button>Nie</button></a><button type="submit">Tak</button>/td>
            </tr>

    </table>
    </form>
</div>
</body>
</html>
