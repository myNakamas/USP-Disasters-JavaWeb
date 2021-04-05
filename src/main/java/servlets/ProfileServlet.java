package servlets;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;

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
        for(Cookie themeCookie : request.getCookies()){
            if(themeCookie.getName().equals("theme_c")) {
                if(color==null) color = Character.toString(themeCookie.getValue().charAt(0));
                if(theme==null) theme = Character.toString(themeCookie.getValue().charAt(1));
                themeCookie = new Cookie("theme_c", color + theme);
                response.addCookie(themeCookie);
                break;
            }
        }
        doGet(request, response);

    }
}
