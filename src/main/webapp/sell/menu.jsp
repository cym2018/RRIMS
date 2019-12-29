<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cuige
  Date: 2019/12/27
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>menu</title>
</head>
<body>
<table>
    <tr>
        <th>商品id</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${menu}" var="menu">
        <tr>
            <td>${menu.goodsid}</td>
            <td>${menu.name}</td>
            <td>${menu.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/sell/menu/delete?goodsid=${menu.goodsid}">
                    <button>删除</button>
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/sell/menu/select?goodsid=${menu.goodsid}">
                    <button>修改</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/sell/menu/creat.jsp">
    <button>添加</button>
</a>

</body>
</html>
