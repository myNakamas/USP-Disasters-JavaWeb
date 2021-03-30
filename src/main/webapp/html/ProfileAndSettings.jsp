<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 29-Mar-21
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <c:import url="components/head.jsp"/>
</head>
<body>
<%--        todo: add settings, customizations and theme changing--%>
    <div class="vertical-wrapper">
        <form method="post" action="${pageContext.request.contextPath}/ProfileAndSettings">
            <div class="settings">
                    <h2>Theme settings</h2>
                <div class="border-wrapper">
                    <div class="theme-dark flex-btn" onclick="changeTheme('#123','#fff','#123')"> Dark Theme</div>
                    <div class="theme-dimmed flex-btn" onclick="changeTheme('#123','#fff','#123')">Dimmed Theme</div>
                    <div class="theme-light flex-btn" onclick="changeTheme('#123','#fff','#123')">Light theme</div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
