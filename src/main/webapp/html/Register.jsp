<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  Created by IntelliJ IDEA.
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
    <h1 class="header-text">Sign up</h1>
        <div class="vertical">
                <form method="post" action="${pageContext.request.contextPath}/Register">

                    <label style="display:none;" for="username">Username</label>
                    <input class="textbox w-small" name="username" id="username" type="text" placeholder="Username*">
                    <label style="display:none;" for="email">Email</label>
                    <input class="textbox w-small" name="email" id="email" type="email" placeholder="Email*">
                    <label style="display:none;" for="phone">Phone</label>
                    <input class="textbox w-small" name="phone" id="phone" type="text" placeholder="Phone">
                    <label style="display:none;" for="password">Password</label>
                    <input class="textbox w-small" name="password" id="password" type="password" placeholder="Password*">
                    <label style="display:none;" for="password2">Password2</label>
                    <input class="textbox w-small" name="password2" id="password2" type="password" placeholder="Rewrite the password*">

<%--                    TODO OPTIONAL: add Captcha--%>
                    <p>The textboxes marked with * are mandatory!</p>
                    <input class="btn vertical-button" type="submit" value="Register">
                </form>
            <c:choose>
                <c:when test="${requestScope.error!=null}">
                    <c:import url="components/ErrorDiv.jsp"/>
                </c:when>
            </c:choose>
        </div>
    </div>

    <div class="horizontal-flex-buttons">
        <a class="flex-btn btn" href="${pageContext.request.contextPath}/">
            Back to Home page
        </a>
        <a class="flex-btn btn" href="${pageContext.request.contextPath}/LostData">
            Lost username or password
        </a>
        <a class="flex-btn btn" href="${pageContext.request.contextPath}/Login">
            Already have an account? <br> Log in.
        </a>
    </div>

</body>
</html>
