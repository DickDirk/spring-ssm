<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        function dels() {
            var byName = document.getElementsByName("ids");
            var arr = new Array();
            for (var i = 0; i < byName.length; i++) {
                if (byName[i].checked) {
                    arr.push(byName[i].value);
                    console.log(arr)
                }
            }
            location.href = "${pageContext.request.contextPath}/student/del?ids=" + arr;
        }
    </script>
</head>
<body>
<h1>学生信息列表</h1>
<a href="/add.jsp">新增</a>
&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
<button onclick="dels()">批量删除</button>

<table border="1" cellspacing="0">
    <tr>
        <th></th>
        <th>学生id</th>
        <th>学生名称</th>
        <th>学生性别</th>
        <th>学生年龄</th>
        <th>居住地址</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="stu">

        <tr>
            <td><input type="checkbox" name="ids" value="${stu.id}"></td>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>
                    ${stu.sex==0?'男':stu.sex==1?'女':'其他'}
            </td>
            <td>${stu.age}</td>
            <td>${stu.address}</td>
            <td>
                <a href="/student/updateBefore.do?id=${stu.id}">修改</a>
                &nbsp;&nbsp;
                <a href="/student/delOne.do?id=${stu.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<table border="1" cellspacing="0">
    <tr>
        <td><a href="/student/findAll.do">首页</a></td>
        <c:if test="${pageInfo.pageNum-1>=1}">
            <td><a href="/student/findAll.do?currentPage=${pageInfo.pageNum-1}">上一页</a></td>
        </c:if>
        <c:if test="${pageInfo.pageNum-1<=0}">
            <td>上一页</td>
        </c:if>

        <c:if test="${pageInfo.pageNum+1<=pageInfo.lastPage}">
            <td><a href="/student/findAll.do?currentPage=${pageInfo.pageNum+1}">下一页</a></td>
        </c:if>
        <c:if test="${pageInfo.pageNum+1>pageInfo.lastPage}">
            <td>下一页</td>
        </c:if>
        <td><a href="/student/findAll.do?currentPage=${pageInfo.lastPage}">尾页</a></td>

    </tr>
</table>
</body>
</html>
