<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 3/30/2021
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang = "en">
<head>
    <title>Lost Data</title>
    <c:import url="components/head.jsp"/>
</head>
<body>
<div class="wrapper">
    <div class="navigation-bar">
        <div class="nav-left">
            <a class="button" href="${pageContext.request.contextPath}/">Back </a>
        </div>
        <div class="title-box">
            <h1 class = "header-title" >Forgotten username or password</h1>
        </div>
    </div>
    <div class="vertical" >
        <p>An email with a reset password link will be sent. Please check your inbox.</p><br>
        <label>
        <input class="textbox vertical-button width30per"  name="email" type="email" placeholder="E-mail">
        </label>
        <a class="button" href="">Reset password </a>
    </div>
</div>
</body>
</html>
