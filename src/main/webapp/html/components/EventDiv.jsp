<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 18.3.2021 г.
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
    <a href="${pageContext.request.contextPath}/EventDetails?id=${requestScope.i}">
    <div class="event-wrapper">
        <h3 class="event-title">
            ${sessionScope.events.get(requestScope.i).title}
        </h3>
        <div class="event-content">
            <p class="event-category">  Category: ${sessionScope.events.get(requestScope.i).category.toUpperCase()}</p>
            <p class="event-date"> Start: ${sessionScope.events.get(requestScope.i).start.toGMTString()}</p>
            <p class="event-date">  End: ${sessionScope.events.get(requestScope.i).end.toGMTString()}</p>
        </div>
    </div>
    </a>

