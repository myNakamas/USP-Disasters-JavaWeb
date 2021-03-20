<%--
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
    <%String event = request.getParameter("Event");%>

    <div style= "border: 5px solid sandybrown" class="event-wrapper">
        <h3 class="event-title">
            <%=event%>
        </h3>
    <div class="event-content">
    <label>My name is Spiro...SUPER spiro</label>

    <h6 style="color: red">My name is Spiro...SUPER spiro</h6>
    </div>
    </div>


<%--</body>--%>
<%--</html>--%>
