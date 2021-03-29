<%--  Created by IntelliJ IDEA.
  User: Angel
  Date: 17-Mar-21
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="web-resources/CSS/css.css" type="text/css">

</head>
<body>
<div class="wrapper">
    <h1 class="header-text">Sign up</h1>

        <div class="vertical">
                <form method="post" action="${pageContext.request.contextPath}/Register">

                    <label style="display:none;" for="username">Username</label>
                    <input class="textbox" name="username" id="username" type="text" placeholder="Username">
                    <label style="display:none;" for="email">Email</label>
                    <input class="textbox" name="email" id="email" type="email" placeholder="Email">
                    <label style="display:none;" for="phone">Phone</label>
                    <input class="textbox" name="phone" id="phone" type="text" placeholder="Phone">
                    <label style="display:none;" for="password">Password</label>
                    <input class="textbox" name="password" id="password" type="password" placeholder="Password">
                    <label style="display:none;" for="password2">Password2</label>
                    <input class="textbox" name="password2" id="password2" type="password" placeholder="Rewrite the password">
<%--                    TODO: add Country and Captcha--%>
                    <input class="btn vertical-button" type="submit" value="Register">
                </form>
        </div>
    </div>

    <div class="horizontal-flex-buttons">
        <a class="flex-btn btn" href="${pageContext.request.contextPath}/">
            Back to Home page
        </a>
        <a class="flex-btn btn" href="${pageContext.request.contextPath}/Login">
            Already have an account? <br> Log in.
        </a>
    </div>

</body>
</html>
