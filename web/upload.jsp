<%--
  Created by IntelliJ IDEA.
  User: stundent
  Date: 3/15/19
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
    <h2>File Upload Demo</h2>
    <form method="post" action="upload" enctype="multipart/form-data">
        Musteri: <input type="text" name="customer"> <br/>
        Beyanname: <input type="file" name="declaration"> <br/>
        <input type="submit" value="Beyanname yukle">
    </form>
</body>
</html>
