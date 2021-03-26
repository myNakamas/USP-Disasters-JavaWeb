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
    <title>Title</title>
    <link rel="stylesheet" href="web-resources/CSS/css.css" type="text/css">

</head>
<body>
<div class="wrapper">
    <h1>${requestScope.eventTitle}</h1>

    <div class = wrapper>
        <div class="box-border-down">
            <p> ${requestScope.eventCategory}</p>
            <p> ${requestScope.eventStart}</p>
        </div>
        <%--TODO: SHOW MORE INFORMATION FOR THE EVENT.--%>
            <div class = "detailContainer">
                <div class ="description">
                    <p> ${requestScope.eventDescription}</p>
                </div>
                <div class="mapContainer">
                    <iframe width="600" height="500" id="gmap_canvas"
                                    src="https://maps.google.com/maps?q=${requestScope.eventLocation}&hl=es&z=7&amp;output=embed">
                    </iframe>

                </div>
            </div>
    </div>
</div>
<div class="">
    <a class="btn" href="${pageContext.request.contextPath}/">
        Back to Home page
    </a>
</div>


</body>
</html>

