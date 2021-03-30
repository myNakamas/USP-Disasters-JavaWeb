package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("html/ProfileAndSettings.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //change the selected settings
        String color = request.getParameter("color");
        String theme = request.getParameter("theme");
        System.out.println("color = "+color);
        System.out.println("theme = "+theme);

        Cookie themeCookie= new Cookie("theme_c",color+theme);
        response.addCookie(themeCookie);

        doGet(request, response);

    }
}
