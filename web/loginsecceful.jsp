<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2021/6/28
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>${user.name}登录成功</h1>
<a href="${pageContext.request.contextPath}/findUserPage">查找所有的用户</a>
</body>
</html>
