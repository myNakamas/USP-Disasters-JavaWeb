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
        <dev style = " display: inline-block; width : 85%; text-align: center;">
        <h1>Disaster information</h1>
        </dev>
        <dev style = " display: inline-block; width : 25%; alignment: right; ">
        <a href="${pageContext.request.contextPath}/Login" class = "button" >⚰Log in</a>
            <a href="${pageContext.request.contextPath}/Register" class = "button" >Sign up</a>
        </dev>
    </nav>
</body>
</html>