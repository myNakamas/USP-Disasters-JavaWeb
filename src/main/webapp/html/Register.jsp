<%@ page import="json.GoogleMapsAPI" %><%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 17-Mar-21
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="CSS/css.css" type="text/css">

</head>
<body>
<%--dynamic including--%>

<jsp:include page='superSpiro.jsp'>
    <jsp:param name="Event" value="This is the first event "/>
</jsp:include>      <%-- We can pass different parameters like this, so it will be easier to work--%>

<%--We can use an embed map to display an event--%>
<%--<div class="mapouter">--%>
<%--    <div class="gmap_canvas">--%>
<%--        <iframe width="600" height="500" id="gmap_canvas"--%>
<%--                src="https://maps.google.com/maps?q=43.5646046,27.81603&hl=es&z=14&amp;output=embed">--%>
<%--        </iframe>--%>
<%--        <a href="https://youtube-embed-code.com">youtube embed code</a>--%>
<%--        <br><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}</style>--%>
<%--        <a href="https://www.embedgooglemap.net">how to add google maps to a website</a>--%>
<%--        <style>.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}</style>--%>
<%--    </div>--%>
<%--</div>--%>


</body>
</html>
