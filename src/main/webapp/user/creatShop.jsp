<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>creatShop</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/shop/creat">
    <label>店铺名:
        <input name="username">
    </label>
    <br>
    <button type="submit">创建</button>
</form>
</body>
</html>
