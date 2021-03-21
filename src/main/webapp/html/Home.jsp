<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="web-resources/CSS/css.css" type="text/css">
</head>
<body>
<%--    <%=session.getAttribute("events")%>--%>
    <h1 class="header-title">Disaster information</h1>
    <nav class="navigation-bar">
        <div class="nav-right">
<%--            <% if(session.getAttribute("currentUser")==null)  This is one way to make an if statement with jsp--%>
            <c:choose> <%--And this is an if else statement with jstl--%>
                <%--@elvariable id="currentUser" type="models.User"--%>
                <c:when test="${sessionScope.user == null}">
                <a class= "button" href="${pageContext.request.contextPath}/Login">⚰Log in</a>
                <a class= "button" href="${pageContext.request.contextPath}/Register">Sign up</a>
                </c:when>
                <c:otherwise>
                    <jsp:include page='components/User-drop-menu.jsp'/>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>


</body>
</html>