package servlets;

import api.ApiPredictHQ;
import models.Result;
import models.entities.User;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "home")
public class HomeServlet extends HttpServlet {
    private ArrayList<Result> events= new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        //this is absolutely not professional. but its what i know so far.
        //events = ApiPredictHQ.basicSearch();//new ArrayList<Result>();
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        try {


        String country = request.getParameter("country");
            if(country.isBlank()) events = ApiPredictHQ.basicSearch();
            else {
                String countryCode = country.substring(country.indexOf(':') + 1);
                System.out.println(countryCode);
                events = ApiPredictHQ.FilteredSearch(countryCode);
            }

        doGet(request,response);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
