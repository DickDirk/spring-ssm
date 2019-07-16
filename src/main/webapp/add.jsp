<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <h1>新增页面</h1>
  <form action="${pageContext.request.contextPath}/student/add" method="post">
    学生姓名：<input type="text" name="name"><br/>
    学生性别：<input type="radio" checked="checked" name="sex" value="0" />男<input type="radio"  name="sex" value="1"/>女<br/>
    学生年龄：<input type="text" name="age"><br/>
    学生地址：<input type="text" name="address"><br/>
    <button type="submit">新增</button>
  </form>
</body>
</html>
