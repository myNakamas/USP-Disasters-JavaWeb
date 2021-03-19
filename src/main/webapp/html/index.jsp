<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="indexCSS.css">
</head>
<body>
    <nav class="navigation-bar">
        <ul>
            <h1>USP-Disasters</h1>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath}/Login">Login</a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath}/Register">Register</a>
            </li>
        </ul>
    </nav>
    <br/>
</body>
</html>