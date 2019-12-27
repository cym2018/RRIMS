<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/19
  Time: 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>user list</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>类型</th>
    </tr>
    <c:forEach items="${user}" var="user">
        <tr>
            <td>${user.userid}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.type}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
