<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
用户id:${userInfo.userid}<br/>
用户名:${userInfo.username}<br/>
密码:${userInfo.password}<br/>
<br/>
<br/>
<a>我的店铺:</a><br>
<c:forEach items="${shopInfo}" var="shop">
    <a href="${pageContext.request.contextPath}/sell/info?shopId=${shop.userid}"> ${shop.username}</a><br/>

</c:forEach>
<br/>
<a href="../sell/creat.jsp">新建店铺</a><br>
<br/>
<a href="${pageContext.request.contextPath}/buy/list">进入商城</a>

<h1>待签收:</h1>


<table>
    <tr>
        <th>菜名</th>
        <th>价格</th>
        <th>数量</th>
    </tr>
    <c:forEach items="${cart}" var="orders">
        <tr>
            <td>${orders.goods.name}</td>
            <td>${orders.goods.price}</td>
            <td>${orders.orders.number}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
