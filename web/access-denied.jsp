<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 2/8/19
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
    Hormetli ${sessionScope.user.name} &nbsp; ${sessionScope.user.surname}!
    Qara masinlar gelir, qacma!
    IP adresiniz: <%=request.getRemoteHost()%>!
</body>
</html>
