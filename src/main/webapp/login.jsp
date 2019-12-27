<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/login">
    <label>用户名:
        <input name="username">
    </label>
    <br>
    <label>
        密码：
        <input name="password">
    </label>
    <br>
    <button type="submit">登陆</button>
</form>
</body>
</html>
