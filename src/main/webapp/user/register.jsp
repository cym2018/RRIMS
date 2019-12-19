<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/18
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>registered</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/register">
    <label>用户名:
        <input name="username">
    </label>
    <br>
    <label>
        密码：
        <input name="password">
    </label>
    <br>
    <button type="submit">注册</button>

</form>
</body>
</html>
