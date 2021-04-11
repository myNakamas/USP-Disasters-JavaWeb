package servlets;

import services.UserCookieService;
import util.HibernateUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/Logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var session = request.getSession(false);

        UserCookieService cookieService = new UserCookieService();
        for(Cookie cookie : request.getCookies())
        {
            if(cookie.getName().equals("remember"))
            {
                cookieService.delete(Long.parseLong(cookie.getValue()));
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        session.invalidate();

        response.sendRedirect(request.getContextPath()+"/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
