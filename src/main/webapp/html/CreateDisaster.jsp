<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Disasters</title>
    <c:import url="components/head.jsp"/>
</head>
<body>
    <nav class="navigation-bar">
        <div class="nav-left">

        </div>
        <div class = "logo"></div>
            <a href="${pageContext.request.contextPath}/"><h1 class="header-title">Disaster information</h1></a>
        <div class="nav-right">
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

    <form method="post" action="${pageContext.request.contextPath}/CreateEvent">
        <div class="vertical" style="margin: 0 25%;">
        <input class="textbox w-small" style="margin: 2% 10% 2% 0" name="title" id="title" type="text" placeholder="Title">
        <input class="textbox w-small"  name="desc" id="desc" type="text" placeholder="Description">
        <label>
            <input placeholder="Select a country." class="search-box" type="text"  list="countries" name="country" value="${requestScope.country}" />
            <datalist id="countries">
                <%
                    for(String countryCode : Locale.getISOCountries()){
                        Locale locale = new Locale("", countryCode);
                %>
                <option value="<%=locale.getDisplayCountry()+" :"+locale.getCountry()%>"></option>
                <%}%>
            </datalist>
        </label><br>
        <label for="start" >Start date :</label>
        <input class="textbox" type="date" id="start" name="start"><br>
        <label for="end" >End  date :</label>
        <input class="textbox" type="date" id="end" name="end" >
        <!--
        title, description - za pisane
        country - padasht list
        start,end - data ot kalendar
        location - ot google maps ?? :D
        -->
            <input class="btn vertical-button" type="submit" value="Create Event">
            <c:if test="${requestScope.error != null}">
                <div class="error-container">
                    <p>${requestScope.error}</p>
                    <c:remove var="error" scope="request"/>
                </div>
            </c:if>
        </div>
    </form>

</body>
</html>