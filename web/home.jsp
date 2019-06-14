<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 2/6/19
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Home page</title>
</head>
<body>
    Hormetli ${sessionScope.user.name} &nbsp; ${sessionScope.user.surname}! <br/>
    Giris tarixi: ${sessionScope.loginTime}

    <a href="logout">Cixis</a>

</body>
</html>
