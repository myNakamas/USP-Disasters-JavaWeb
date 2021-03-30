<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 20-Mar-21
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Details</title>
    <c:import url="components/head.jsp"/>

</head>
<body>
    <div class="wrapper">
        <div class="box-border-down">
            <div class="nav-left">
                <a class="button" href="${pageContext.request.contextPath}/">Back </a>
            </div>
            <div class="title-box">
                <h1>${requestScope.eventTitle}</h1>
            </div>
        </div>
        <div class=wrapper>
            <div class="detailContainer">
                <div class="description">
                    <h1>Description</h1>
                    <table>
                        <tr>
                            <td><b>Category :</b>${requestScope.eventCategory.toUpperCase()}</td>
                        </tr>
                        <tr>
                            <td><b>Start :</b>${requestScope.eventStart.toGMTString()}</td>
                        </tr>
                        <tr>
                            <td><b>End :</b>${requestScope.eventEnd.toGMTString()}</td>
                        </tr>
                        <c:choose>
                            <c:when test="${requestScope.eventDuration!=0}">
                                <tr>

                                    <td><b>Duration :</b>${requestScope.eventDuration}</td>
                                </tr>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${!requestScope.eventDescription.equals('')}">
                                <tr>
                                    <td><b>Additional information :</b>${requestScope.eventDescription}</td>
                                </tr>
                            </c:when>
                        </c:choose>
                        <tr>
                            <td><b>Relevance :</b>${requestScope.eventRelevance}</td>
                        </tr>
                        <c:choose>
                            <c:when test="${requestScope.eventTimezone != null}">
                                <tr>
                                    <td><b>Timezone :</b>${requestScope.eventTimezone}</td>
                                </tr>
                            </c:when>
                        </c:choose>
                    </table>
                </div>
            </div>
            <div class="mapContainer">
                <iframe title="Location" class="map" width="600" height="500" id="gmap_canvas"
                        src="https://maps.google.com/maps?q=${requestScope.eventLocation}&hl=es&z=7&amp;output=embed">
                </iframe>

            </div>
        </div>
    </div>


</body>
</html>

