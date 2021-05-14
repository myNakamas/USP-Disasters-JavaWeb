package servlets;

import api.ApiPredictHQ;
import models.entities.Disaster;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import services.DisasterService;

@WebServlet(name = "CreateServlet", value = "/CreateServlet")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("html/CreateDisaster.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String desc = request.getParameter("desc");
        String country = request.getParameter("country");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String countryCode = "";

        try {
            DisasterService disasterService = new DisasterService();
            if (title.equals("") || desc.equals("") || start.equals("") || end.equals("") || !country.contains(":")) {
                throw new IOException("Some fields are empty or the input is wrong!");
            }

            if (!country.isBlank()) {
                countryCode = country.substring(country.indexOf(':') + 1);
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date Start = format.parse(start);
            Date End = format.parse(end);
            Disaster elem = new Disaster(title, desc, Start, End, countryCode, "not yet lmao");
            disasterService.persist(elem);
            response.sendRedirect(request.getContextPath() + "/");
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("html/CreateDisaster.jsp").forward(request, response);
        }
    }
}

