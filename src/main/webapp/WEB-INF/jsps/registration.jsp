<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.08.2017
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new user</title>

</head>
<body>
<form method="post" action="/register">
    <div>
        <label>Login</label>
        <input type="text" id="login" name = "login">
    </div>
    <div>
        <label>Username</label>
        <input type="text" id="username" name = "username">
        <div>
            <label>Password</label>
            <input type="text" id="password" name = "password">
        </div>
        <div>
            <%--<input type="hidden" name=""--%>
            <input type="submit" value = "Register">
        </div>
    </div>
</form>
</body>
</html>
