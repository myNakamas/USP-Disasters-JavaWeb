<%@ page import="java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Disasters</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#000">
    <meta name="Description" content="A Website displaying information about the Disasters around the world.">
    <link rel="apple-touch-icon" href="web-resources/images/logo/Disaster-logo180x180.png">
    <link rel="icon" type="image/gif" href="web-resources/images/logo/Disaster-logo32x32.png">
    <link rel="manifest" href="web-resources/json/manifest.json">
<%--    not sure for the href--%>
    <link rel="stylesheet" href="web-resources/CSS/css.css" type="text/css">
    <script src="js/themeFunctions.js"></script>
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

<%--        This is a javascript function to change the theme--%>
        <div class="btn" onclick="changeTheme('#123','#fff','#123')">ClickME</div>


        <div class="event-page">
            <%int i=0;%>
            <c:forEach items="${sessionScope.events}" var = "event">
                <% request.getSession().setAttribute("i",i++);%>
                <jsp:include page="components/EventDiv.jsp"/>
            </c:forEach>
        </div>
    </div>


</body>
</html>