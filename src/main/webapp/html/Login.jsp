<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 17-Mar-21
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="CSS/css.css" type="text/css">

</head>
<body>
<div class="wrapper">
    <h1 class="header-text">Log in</h1>

    <div class="box-border-down">
        <div class="login-left">
            <form method="post" action="${pageContext.request.contextPath}/Login">
                <label class="textbox">
                    <input name="username" type="text" placeholder="username">
                </label>
                <label class="textbox">
                    <input name="password" type="password" placeholder="password">
                </label>
                <input class="btn" type="submit" value="Log in">
            </form>
        </div>
        <div class="login-right">
            <button class="btn">

            </button>
            <button class="btn">

            </button>
        </div>
    </div>
</div>
</body>
</html>
