<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.Result" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 18.3.2021 г.
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>For Spiro We Live</title>--%>
<%--    <link rel="stylesheet" href="CSS/css.css" type="text/css">--%>

<%--</head>--%>
<%--<body>--%>

<%--Get the parameter that was passed through the outer jsp file--%>

<% ArrayList<Result> events = (ArrayList<Result>)request.getSession().getAttribute("events"); int i = (int) request.getSession().getAttribute("i");%>

    <div style= "border: 5px solid sandybrown" class="event-wrapper">
        <h3 class="event-title">
            <%=events.get(i).getTitle()%>
        </h3>
        <div class="event-content"></div>
    </div>



<%--</body>--%>
<%--</html>--%>
