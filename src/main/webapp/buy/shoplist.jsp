<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>shoplist</title>
</head>
<body>
<h1>商店列表</h1>
<c:forEach items="${shoplist}" var="shop">
    <a href="${pageContext.request.contextPath}/buy/selectshop?shop.userid">${shop.username}</a><br/>
</c:forEach>
</body>
</html>
