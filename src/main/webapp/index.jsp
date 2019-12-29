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
<a href="">主页</a><br/>
<a href="login.jsp">登陆</a><br/>
<a href="register.jsp">注册</a><br/>
<a href="${pageContext.request.contextPath}/sell/creat">创建店铺</a><br/>
<a href="${pageContext.request.contextPath}/user/info">用户信息</a><br/>
<a href="${pageContext.request.contextPath}/buy/list">商店列表</a><br/>
</body>
</html>
