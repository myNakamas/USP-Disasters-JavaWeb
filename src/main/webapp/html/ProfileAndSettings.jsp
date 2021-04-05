<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 29-Mar-21
  Time: 20:29
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
<div class="box-border-down">
    <div class="nav-left">
        <a class="button" href="${pageContext.request.contextPath}/">Back </a>
    </div>
    <div class="title-box">
        <h1>Settings</h1>
    </div>
</div>
<div class="vertical-wrapper">
    <div class="vertical-navigaiton"></div>
    <div class="settings-container">
    <form method="post" action="${pageContext.request.contextPath}/ProfileAndSettings">
        <div class="settings">
            <h2>Personal settings </h2>
            <div class="">
                <label>
                    <input class="textbox" type="text" placeholder="username"/>
                </label>
                <label>
                    <input class="textbox" type="text" placeholder="pass"/>
                </label>
                    <input class="btn" type="file" name="upload-profile-pic" value=""/>
            </div>
        </div>
        <div class="settings">
            <h2>Theme settings</h2>
            <div class="border-wrapper">
                <label class="theme-dark flex-btn" onclick="changeTheme(0)">
                    <input type="radio" id="dark" name="theme" value="0" >
                    Dark Theme
                </label>
                <label class="theme-dimmed flex-btn" onclick="changeTheme(1)">
                    <input type="radio" id="dimmed" name="theme" value="1">
                    Dimmed Theme
                </label>
                <label class="theme-light flex-btn" onclick="changeTheme(2)">
                    <input type="radio" id="light" name="theme" value="2">
                    Light theme
                </label>
            </div>
            <div class="border-wrapper">
                <label class="orange-btn flex-btn"  onclick="changePrimColor(0)">
                    <input type="radio" id="orange" name="color" value="0">
                     Orange
                </label>
                <label class="purple-btn flex-btn" onclick="changePrimColor(1)" >

                    <input type="radio" id="purple" name="color" value="1">
                     Purple
                </label>
                <label class="cyan-btn flex-btn" onclick="changePrimColor(2)">
                    <input type="radio" id="cyan" name="color" value="2"<c:if test="${requestScope.color}=='2'"> checked </c:if>>
                    Cyan
                </label>
            </div>
        </div>

        <input class="btn vertical-button" type="submit" value="Save">
    </form>
    </div>
</div>
</body>
</html>
