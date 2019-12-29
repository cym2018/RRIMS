<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/18
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>failure</title>
</head>
<body>
${message}<br/>
<a href="${pageContext.request.contextPath}/index.jsp">主页</a><br/>
<a href="${pageContext.request.contextPath}/buy/list">商店列表</a><br>
<a href="${pageContext.request.contextPath}/user/info">我的信息</a><br>
<a href="${pageContext.request.contextPath}/buy/shop">返回商店</a><br>
<a href="${pageContext.request.contextPath}/login.jsp">登陆</a><br>
<a href="${pageContext.request.contextPath}/register.jsp">注册</a><br>
<a href="${pageContext.request.contextPath}/sell/info">商店信息</a><br>
<a href="${pageContext.request.contextPath}/sell/menu">菜单管理</a><br>
</body>
</html>
