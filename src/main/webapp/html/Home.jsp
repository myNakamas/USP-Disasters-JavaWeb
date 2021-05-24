<%@ page import="java.util.Locale" %>
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


    <c:if test="${requestScope.offset==null}">
        <c:set var="offset" scope="request" value="0"/>
    </c:if>
    <c:if test="${requestScope.country==null}">
        <c:set var="country" scope="request" value=""/>
    </c:if>
    <div class="vertical">
        <div class="search-bar-container">
            <form method="post">
                <div>
                <label>
                    <input placeholder="Select a country." class="search-box" type="text" list="countries" name="country" value="${requestScope.country}" />
                    <datalist id="countries">
                        <%
                            for(String countryCode : Locale.getISOCountries()){
                            Locale locale = new Locale("", countryCode);
                        %>
                            <option value="<%=locale.getDisplayCountry()+" :"+locale.getCountry()%>"></option>
                        <%}%>
                    </datalist>

                </label>
                    <div>
                <label>
                    <input class="textbox" type="date" name="afterDate" placeholder="After:" />
                </label>
                    </div>
                    <div>
                <label>
                    <input class="textbox" type="date" name="beforeDate" placeholder="Before:" />
                </label>
                    </div>
                </div>
                <input class="flex-btn btn" type="submit" value="Search">
                <input type="hidden" value="${requestScope.offset}" name="offset">
                <div>
                    <c:if test="${requestScope.offset>=20}">
                    <input type="submit" value="Previous" name="previous" class="btn">
                    </c:if>
                    <c:if test="${sessionScope.events.size() == 20}">
                    <input type="submit" value="Next" name="next" class="btn">
                    </c:if>
                </div>
            </form>
        </div>
        <div class="event-page">
            <c:choose>
                <c:when test="${requestScope.country==null}">
                    <p>Search for a specific country or just press Search for the latest occurrences!</p>
                </c:when>
                <c:when test="${requestScope.country.equals('world')}">
                    <p>Showing information from all around the globe!</p>
                </c:when>
                <c:otherwise>
                    <p>Showing information about ${requestScope.country}</p>
                </c:otherwise>
            </c:choose>

            <%int i=0;%>
            <c:forEach items="${sessionScope.events}" var = "event">
                <% request.setAttribute("i",i++);%>
                <jsp:include page="components/EventDiv.jsp"/>
            </c:forEach>
        </div>
    </div>


</body>
</html>