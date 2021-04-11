package servlets;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("html/ProfileAndSettings.jsp");
        for(var cookie : request.getCookies())
        {
            if(cookie.getName().equals("theme_c")){
                request.setAttribute("color",cookie.getValue().charAt(0));
                request.setAttribute("theme",cookie.getValue().charAt(1));
            }
        }

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //change the selected settings
        String color = request.getParameter("color");
        String theme = request.getParameter("theme");
        Cookie[] cookies = request.getCookies();
        Cookie cookie = new Cookie("theme_c","00");
        for(Cookie themeCookie : cookies ){
            if(themeCookie.getName().equals("theme_c")) {
                cookie = themeCookie;
                break;
            }
        }
        //if any of the inputs are null, they get the last value
        if(color==null) color = Character.toString(cookie.getValue().charAt(0));
        if(theme==null) theme = Character.toString(cookie.getValue().charAt(1));

        cookie = new Cookie("theme_c", color + theme);
        response.addCookie(cookie);
        doGet(request, response);

    }
}
