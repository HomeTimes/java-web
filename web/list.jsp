<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2021/6/24
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script>
        //删除指定用户：加确认框
        function DeleteUserById(id) {
            //实验证明：第一种方法删除不了
            <%--var DeleteUserById= document.getElementById("DeleteUserById")--%>
            <%--if(confirm("确认删除吗")){--%>
            <%--    DeleteUserById.href="${pageContext.request.contextPath}/DeleteUserById?id="+id;--%>
            <%--}--%>
            //实验证明：采用第二种
            if(confirm("确认删除吗")){
                location.href="${pageContext.request.contextPath}/DeleteUserById?id="+id;
            }
        }

        window.onload=function  deleteSelected() {
            //删除选中提交
           var form= document.getElementById("form");
           var allbox=document.getElementById("allBox")
            var deleteSelected=document.getElementById("deleteSelected")
            deleteSelected.onclick=function (ev) {
               if(confirm("确认要删除吗")){
                   var flag=false
                   var uid=document.getElementsByName("uid");
                   for(var i=0;i<uid.length;i++){
                       if(uid[i].checked){
                           var flag=true
                           break;
                       }
                   }
                   if(flag==true){
                       form.submit();
                   }
               }

            }
            //通过一选多个按钮

                 allbox.onclick=function () {
                     var uid=document.getElementsByName("uid");
                     for (var i = 0;i<uid.length;i++){
                         uid[i].checked= allbox.checked
                     }
                 }
             }


    </script>
</head>
<style type="text/css">
    tr,th{
        text-align: center;
    }
    table{
        margin-top: 50px;
    }
</style>
<body>
<div class="container" style="text-align: center;">
    <h1>用户信息表</h1>
    <div style="float: left;">
        <form class="form-inline" method="post" action="${pageContext.request.contextPath}/findUserPage">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">籍贯</label>
                <input type="text" name="address" class="form-control" id="exampleInputEmail2" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail3">邮箱</label>
                <input type="email" name="email" class="form-control" id="exampleInputEmail3" >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div id="" style="float: right; margin-right: 20px;">
        <a href="${pageContext.request.contextPath}/add.jsp" class="btn btn-primary">添加联系人</a>
        <a href="javascript:deleteSelected(0)" class="btn btn-primary" id="deleteSelected">删除选中</a>
    </div>
    <form action="${pageContext.request.contextPath}/deleteSelectedUser" method="get" id="form">
        <table class="table table-bordered">
            <tr>
                <th><input type="checkbox" id="allBox"/></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>qq</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${userPage.list}" var="user" varStatus="s" >
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"/></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a href="${pageContext.request.contextPath}/ComeToUpdatePage?id=${user.id}" class="btn btn-success">修改</a>
                        <a href="javascript:DeleteUserById(${user.id})" id="DeleteUserById" class="btn alert-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </form>
    <div class="page">
        <nav>
            <ul class="pagination pagination-lg">
                <c:if test="${userPage.currentPage==1}">
                    <li class="disabled">
                        <a href="${pageContext.request.contextPath}/findUserPage?CurrentPage=${userPage.currentPage-1}&rows=3" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${userPage.currentPage!=1}">
                    <li class="">
                        <a href="${pageContext.request.contextPath}/findUserPage?CurrentPage=${userPage.currentPage-1}&rows=3" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach begin="1" end="${userPage.totalPage}" var="i">
                    <c:if test="${i == userPage.currentPage}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserPage?CurrentPage=${i}&rows=3">${i}</a></li>
                    </c:if>
                    <c:if test="${i != userPage.currentPage}">
                        <li ><a href="${pageContext.request.contextPath}/findUserPage?CurrentPage=${i}&rows=3">${i}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                共${userPage.totalCount}条，${userPage.totalPage}页
            </ul>
        </nav>
    </div>
</div>
</body>
</html>

