<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2021/6/24
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
       function reflesh() {
         var img=document.getElementById("img")
          img.src="${pageContext.request.contextPath}/code?time="+new Date().getTime();
       }
    </script>
  </head>
  <body>
   <div style="width: 400px;margin: 0 auto">
     <h1 style="text-align: center"> 管理员登录</h1>
     <form action="${pageContext.request.contextPath}/login" method="get">
       <div class="form-group">
         <label for="exampleInputEmail1">用户名</label>
         <input type="text" class="form-control" name="username" id="exampleInputEmail1" placeholder="Email">
       </div>
       <div class="form-group">
         <label for="exampleInputPassword1">密码</label>
         <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
       </div>
       <div class="form-inline">
         <div class="form-group">
           <label for="exampleInputName2">验证码：</label>
           <input type="text" class="form-control" name="verifycode" id="exampleInputName2" placeholder="Jane Doe">
         </div>
         <a href="javascript:reflesh()">
           <img src="${pageContext.request.contextPath}/code" id="img" title="看不清，请点击一下">
         </a>
       </div>
       <div class="form-group" style="text-align: center;">
         <input class="btn btn-success" type="submit" value="登录">
       </div>
     </form>
     <p>${err_code}----${err_login}</p>
   </div>
  </body>
</html>
