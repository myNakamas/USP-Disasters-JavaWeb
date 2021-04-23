<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 21-Mar-21
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<div class="dropdown">
    <img class="profile-pic" src="web-resources/images/userPic/image.png" alt="">
    <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/ProfileAndSettings">Profile</a>
            <a href="${pageContext.request.contextPath}/Logout">Log out</a>
    </div>
</div>