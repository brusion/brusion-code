<%--
  Created by IntelliJ IDEA.
  User: shundaye
  Date: 2018/4/1
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
        <form action="${pageContext.request.contextPath}/login.action" method="post">
            用户账号：<input type="text" name="name"><br>
            用户密码：<input type="password" name="pwd"><br>
            <input type="submit" value="提交">
        </form>
</body>
</html>
