

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Utwórz osobę</title>
</head>
<body>
<form method="POST" action="">
    <div>
        <label>Login: <input type="text" name="login"/></label>
    </div>
    <div>
        <label>Email: <input type="email" name="email"/></label>
    </div>
    <div>
        <label>Password: <input type="text" name="password"/></label>
    </div>
    <div><button type="submit">Dodaj</button> </div>
</form>

</body>
</html>
