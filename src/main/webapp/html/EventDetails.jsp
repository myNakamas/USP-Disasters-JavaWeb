<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 20-Mar-21
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Details</title>
    <link rel="stylesheet" href="web-resources/CSS/css.css" type="text/css">

</head>
<body>
<div class="wrapper">
    <div class="box-border-down">
    <div class="nav-left">
        <a class="button" href="${pageContext.request.contextPath}/">Back </a>
    </div>
        <div>
            <h1 >${requestScope.eventTitle}</h1>
        </div>
    </div>
    <div class = wrapper>
            <div class = "detailContainer">
                <div class ="description">
                        <h1 >Description</h1>
                    <table>
                        <tr>
                            <td>Category : ${requestScope.eventCategory}</td>
                        </tr>
                        <tr>
                            <td>Start : ${requestScope.eventStart}</td>
                        </tr>
                        <tr>
                            <td>End : ${requestScope.eventEnd}</td>
                        </tr>
                        <tr>
                            <td>Duration : ${requestScope.eventDuration}</td>
                        </tr>
                        <c:choose>
                            <c:when test="${!requestScope.eventDescription.equals('')}">
                        <tr>
                            <td>Additional information : ${requestScope.eventDescription}</td>
                        </tr>
                            </c:when>
                        </c:choose>
                        <tr>
                            <td>Relevance : ${requestScope.eventRelevance}</td>
                        </tr>
                            <c:choose>
                                <c:when test="${requestScope.eventTimezone != null}">
                        <tr>
                            <td>Timezone : ${requestScope.eventTimezone}</td>
                        </tr>
                                </c:when>
                            </c:choose>
                    </table>
                </div>
                </div>
                <div class="mapContainer">
                    <iframe width="600" height="500" id="gmap_canvas"
                                    src="https://maps.google.com/maps?q=${requestScope.eventLocation}&hl=es&z=7&amp;output=embed">
                    </iframe>

                </div>
            </div>
    </div>
</div>



</body>
</html>

