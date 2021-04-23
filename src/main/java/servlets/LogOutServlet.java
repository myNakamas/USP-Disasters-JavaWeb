package servlets;

import services.UserCookieService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/Logout")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
