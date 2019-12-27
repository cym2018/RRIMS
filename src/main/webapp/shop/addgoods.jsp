<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/shop/addgoods">
    商品名:<input name="name"/><br/>
    价格:<input name="price"/><br/>
    <button type="submit">添加</button>
</form>
</body>
</html>
