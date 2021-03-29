<%@ page import="java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#000">
    <link rel="apple-touch-icon" href="web-resources/images/logo/Disaster-logo180x180.png">
<%--    not sure for the href--%>
    <link rel="stylesheet" href="web-resources/CSS/css.css" type="text/css">
</head>
<body>
    <nav class="navigation-bar">
        <div class = "logo"></div>
            <h1 class="header-title">Disaster information</h1>
        <div class="nav-right">
<%--            <% if(session.getAttribute("currentUser")==null)  This is one way to make an if statement with jsp--%>
            <c:choose>
                <%--suppress ELValidationInJSP --%>
                <c:when test="${sessionScope.user == null}">
                <a class= "button" href="${pageContext.request.contextPath}/Login">Log in</a>
                <a class= "button" href="${pageContext.request.contextPath}/Register">Sign up</a>
                </c:when>
                <c:otherwise>
                    <jsp:include page='components/User-drop-menu.jsp'/>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
    <div class="vertical">
        <div class="search-bar-container">
            <form method="post">
                <label>
                    <input placeholder="Select a country." class="search-box" type="text" list="countries" name="country" />
                    <datalist id="countries">
                        <%
                            for(String countryCode : Locale.getISOCountries()){
                            Locale locale = new Locale("", countryCode);
                        %>
                            <option value="<%=locale.getDisplayCountry()+" :"+locale.getCountry()%>"></option>
                        <%}%>
                    </datalist>
                </label>
                <input class="flex-btn btn" type="submit" value="Search">
            </form>
        </div>
        <div class="event-page">
            <%--            I turned off the connection with the api and set up some static info in the home-servlet--%>
            <%--            just so we dont do too many requests from the api accidentally--%>
            <%int i=0;%>
            <c:forEach items="${sessionScope.events}" var = "event">
                <% request.getSession().setAttribute("i",i++);%>
                <jsp:include page="components/EventDiv.jsp"/>
            </c:forEach>
        </div>
    </div>


</body>
</html>