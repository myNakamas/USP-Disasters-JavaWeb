<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 18.3.2021 г.
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>

<%--Get the parameter that was passed through the outer jsp file--%>

<%
    //ArrayList<Result> events = (ArrayList<Result>)request.getSession().getAttribute("events");
    //int i = (int) request.getSession().getAttribute("i");
%>
    <a href="${pageContext.request.contextPath}/EventDetails?id=${sessionScope.i}">
    <div class="event-wrapper">
        <h3 class="event-title">
            ${sessionScope.events.get(sessionScope.i).title}
        </h3>
        <div class="event-content">
            <p class="event-category">  Category: ${sessionScope.events.get(sessionScope.i).category.toUpperCase()}</p>
            <p class="event-date"> Start: ${sessionScope.events.get(sessionScope.i).start.toGMTString()}</p>
            <p class="event-date">  End: ${sessionScope.events.get(sessionScope.i).end.toGMTString()}</p>


        </div>
    </div>
    </a>

