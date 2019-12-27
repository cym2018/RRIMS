<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>updateGoods</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/shop/updategoods">
    <input type="hidden" name="goodsid" value="${goods.goodsid}">
    <label>
        商品名:
        <input name="name" value="${goods.name}"/>
    </label>
    <br/>
    <label>
        价格:
        <input name="price" value="${goods.price}"/>
    </label>
    <br/>
    <button type="submit">更新</button>
</form>
</body>
</html>
