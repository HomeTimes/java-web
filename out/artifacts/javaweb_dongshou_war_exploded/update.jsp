<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2021/6/28
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div id="form-table" style="width: 500px;margin: 0 auto;">
        <form action="${pageContext.request.contextPath}/updateUser" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <div class="form-group">
                <label for="exampleInputEmail1">姓名</label>
                <input type="text" name="name" class="form-control" id="exampleInputEmail1" value="${user.name}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword2">性别</label>
                <input type="text" name="gender" class="form-control" id="exampleInputPassword2"  value="${user.gender}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword3">年龄</label>
                <input type="text" name="age" class="form-control" id="exampleInputPassword3"  value="${user.age}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword4">籍贯</label>
                <input type="text" name="address" class="form-control" id="exampleInputPassword4" value="${user.address}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword5">qq</label>
                <input type="text" name="qq" class="form-control" id="exampleInputPassword5" value="${user.qq}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword6">邮箱</label>
                <input type="text" name="email" class="form-control" id="exampleInputPassword6"  value="${user.email}">
            </div>

            <div  style="text-align: center;" class="form-inline">
                <button type="submit"class="btn btn-success">Submit</button>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/list.jsp">返回</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>

