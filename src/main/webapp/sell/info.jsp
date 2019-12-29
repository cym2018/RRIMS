<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"  %>
<html>
<head>
    <title>店铺名称</title>
</head>
<body>
商铺id:${shopInfo.userid}<br/>
店铺名称:${shopInfo.username}<br/>
店铺所有者:${ownerInfo.username}<br/>
<a href="${pageContext.request.contextPath}/sell/menu">管理菜单</a><br/>
管理订单:<br/>
</body>
</html>
