<%@ page import="models.Result" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="CSS/css.css" type="text/css">
</head>
<body>
<%--    <%=session.getAttribute("events")%>--%>

    <nav class="navigation-bar">
        <ul>
            <li><h1>USP-Disasters</h1></li>
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