<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
    <a href="${pageContext.request.contextPath}/shop/info?id=${shop.userid}"> ${shop.username}</a><br/>

</c:forEach>
<br/>
<a href="creatShop.jsp">新建店铺</a><br>
<br/>
<a href="/buy/shoplist">进入商城</a>
</body>
</html>
