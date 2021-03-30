package servlets;

import api.ApiPredictHQ;
import models.Result;
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
//        Result this1 = new Result("this");
//        this1.setDescription("Something happened at the long lost island of virgin islands. No one knows how many bodies are on the bottom of the sea. One of the civilians says that there was an earthquake that was so strong, that the gates of hell opened and a incubus took his wife.");
//        this1.setCategory("Horror");
//        events.add(this1);
//        events.add(new Result("that"));
        HttpSession session = request.getSession();
        session.setAttribute("events",events);
        response.setContentType("text/html");
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
        HttpSession session = request.getSession();
        session.setAttribute("events",events);

        RequestDispatcher view = request.getRequestDispatcher("html/Home.jsp");
        view.forward(request, response);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
