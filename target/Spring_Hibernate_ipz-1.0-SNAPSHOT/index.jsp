<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 17/05/2021
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p><a href="/book/add"><button>Add book</button></a> </p>
<p><a href="/book/get/{id}"></a> <form><input type="number" name="id"><input type="submit" value="Show book"></form></p>
</body>
</html>
