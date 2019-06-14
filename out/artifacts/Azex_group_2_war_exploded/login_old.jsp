<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 2/6/19
  Time: 9:10 P M
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Zehmet olmasa, email ve sifrenizi daxil edin</h2>

    <c:if test="${not empty sessionScope.errorMessage}">
        ${sessionScope.errorMessage} <br/>
    </c:if>

    <form method="post" action="login">
        Email: <input type="email" name="email"/> <br/>
        Sifre: <input type="password" name="password"/> <br/>
        <input type="submit" value="Daxil ol"/> &nbsp;
        <input type="reset" value="Temizle"/>
    </form>
</body>
</html>
