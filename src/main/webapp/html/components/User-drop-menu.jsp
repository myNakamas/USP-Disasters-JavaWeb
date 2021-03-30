<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 21-Mar-21
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<div class="dropdown">
    <img class="profile-pic" src="" alt="">
    <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/ProfileAndSettings">Profile</a>
            <a onclick=<% logOut(session,response);%> >Log out</a>
    </div>
</div>

<%!
    private void logOut(HttpSession session, HttpServletResponse response) throws IOException {
        session.removeAttribute("user");
        //when we implement cookies, remove the user as well
        response.sendRedirect("/");
    }
%>