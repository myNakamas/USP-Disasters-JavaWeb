<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page - Disasters</title>
</head>
<body>
<!--Todo: make it good looking? -->

<div class = "wrapper">
    <c:forEach items = "${events}" var = "event">
        <div class="event-wrap">
            <h2>${event}</h2>
        </div>
    </c:forEach>

</div>
</body>
</html>