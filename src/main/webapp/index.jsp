<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/15
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<h1>ROOT</h1>
<a href="info.jsp">失败页面</a><br/>
<a href="">主页</a><br/>
<a href="login.jsp">登陆</a><br/>
<a href="register.jsp">注册</a><br/>
<h1>BUY</h1>
<h1>DEBUG</h1>
<a href="${pageContext.request.contextPath}/debug/userlist">用户列表</a><br/>
<h1>SHOP</h1>
<a href="shop/info.jsp">店铺信息</a><br/>
<a href="shop/menu.jsp">菜单</a><br/>
<h1>USER</h1>
<a href="user/creatShop.jsp">创建店铺</a><br/>
<a href="${pageContext.request.contextPath}/user/info">用户信息</a><br/>
</body>
</html>
