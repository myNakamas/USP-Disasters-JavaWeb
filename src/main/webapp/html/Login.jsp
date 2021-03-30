<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 17-Mar-21
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <c:import url="components/head.jsp"/>
</head>
<body>
<div class="wrapper">
    <h1 class="header-text">Log in</h1>
    <c:choose>
        <c:when test="${requestScope.error!=null}">
            <c:import url="components/ErrorDiv.jsp"/>
        </c:when>
    </c:choose>
    <div class="box-border-down">
        <div class="login-left">
            <div class="align-down-right">
                <form method="post" action="${pageContext.request.contextPath}/Login">

                    <label style="display:none;" for="username">Username</label>
                    <input class="textbox" name="username" id="username" type="text" placeholder="Username">
                    <label style="display:none;" for="password">Password</label>
                    <input class="textbox" name="password" id="password" type="password" placeholder="Password">
                    <div class="input-checkbox">
                        <input type="checkbox" id="keepLoggedIn" name="keepLoggedIn">
                        <label for="keepLoggedIn">Keep me logged in</label>
                    </div>
                    <input class="btn vertical-button" type="submit" value="Log in">

                </form>
            </div>
        </div>
        <div class="login-right">
            <div class="align-down-left">
            <button class="btn vertical-button">
            Login with Google
            </button>
            <button class="btn vertical-button">
            Login with Facebook
            </button>
            </div>
        </div>
    </div>
    <div class="horizontal-flex-buttons">
                <a class="flex-btn btn" href="${pageContext.request.contextPath}/">
                    Back to Home page
                </a>
                <a class="flex-btn btn" href="${pageContext.request.contextPath}/LostData">
                    Forgotten name or password
                </a>
                <a class="flex-btn btn" href="${pageContext.request.contextPath}/Register">
                    Create account
                </a>
    </div>
</div>
</body>
</html>
