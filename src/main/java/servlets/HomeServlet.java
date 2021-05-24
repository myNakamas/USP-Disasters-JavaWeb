package servlets;

import api.ApiPredictHQ;
import models.Result;
import models.entities.User;
import util.HibernateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "home")
public class HomeServlet extends HttpServlet {
    private ArrayList<Result> events= new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        User user = LoginServlet.checkCookie(request);

        request.getSession().setAttribute("events",events);

        if(user !=null)
        {
            request.getSession().setAttribute("user",user);
        }

        RequestDispatcher view = request.getRequestDispatcher("html/Home.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String country = request.getParameter("country");
        String offsetString = request.getParameter("offset");

        Date beforeDate = convertToDate(request.getParameter("beforeDate"));
        Date afterDate = convertToDate(request.getParameter("afterDate"));
        int offset;

        if(offsetString == null) offset = 0;
        else offset = Integer.parseInt(offsetString);

        if(request.getParameter("next")!=null) offset+=20;
        if(request.getParameter("previous")!=null) offset-=20;

        request.setAttribute("offset",offset);

        String countryCode="";
        if(!country.isBlank())
        countryCode = country.substring(country.indexOf(':') + 1);

        events = ApiPredictHQ.databaseSearch(offset,countryCode,afterDate,beforeDate);

        request.setAttribute("country",country);
        doGet(request,response);

    }

    private static Date convertToDate(String date){
        if(date.isBlank()) return null;
        Instant instant = LocalDate.parse(date).atStartOfDay().toInstant(ZoneOffset.ofHours(1));
        return Date.from(instant);
    }
}
