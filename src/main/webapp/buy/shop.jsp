<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>shop</title>
</head>
<body>
<h1>商品</h1>
<form action="${pageContext.request.contextPath}/buy/shop/add">
    <table>
        <tr>
            <th>名称</th>
            <th>价格</th>
        </tr>
        <c:forEach items="${shopMenu}" var="goods">
            <tr>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td>
                    <button name="goodsid" value="${goods.goodsid}" type="submit">+1</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

<h1>已选商品</h1>
<form action="${pageContext.request.contextPath}/buy/shop/remove">
    <table>
        <tr>
            <th>菜名</th>
            <th>价格</th>
            <th>数量</th>
        </tr>
        <c:forEach items="${cartList}" var="orders">
            <tr>
                <td>${orders.goods.name}</td>
                <td>${orders.goods.price}</td>
                <td>${orders.orders.number}</td>
                <td>
                    <button name="goodsid" value="${orders.goods.goodsid}" type="submit">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
总额:${sumPrice}
<a href="${pageContext.request.contextPath}/buy/shop/pay">
    <button>支付</button>
</a>

</body>
</html>
