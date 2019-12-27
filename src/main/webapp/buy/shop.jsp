<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>shop</title>
</head>
<body>
<table>
    <tr>
        <th>名称</th>
        <th>价格</th>
    </tr>
    <c:forEach items="${menu}" var="goods">
        <tr>
            <td>${goods.name}</td>
            <td>${goods.price}</td>
            <form >

            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
