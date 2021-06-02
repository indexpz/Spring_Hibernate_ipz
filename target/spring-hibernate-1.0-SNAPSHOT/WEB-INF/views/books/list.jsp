<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 30/05/2021
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista książek</title>
</head>
<body>
<p><a href="/forms/book/create">Dodaj książkę</a></p>
<div>
    <table>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Rating</th>
            <th>Description</th>
            <th>Publisher</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.description}</td>
                <td>
                    <ul>>
                        <c:forEach items="${book.authors}" var="author">
                            <li>${author.fullName}</li>
                        </c:forEach>
                    </ul
                </td>
                <td>${book.publisher.name}</td>
                <td><a href="/forms/book/edit?id=${book.id}">
                    <button>Edit</button>
                </a></td>
                <td><a href="/forms/book/delete?id=${book.id}">
                    <button>Delete</button>
                </a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
