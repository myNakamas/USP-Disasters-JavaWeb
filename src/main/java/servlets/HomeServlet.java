package servlets;

import json.ApiPredictHQ;
import models.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "home")
public class HomeServlet extends HttpServlet {
    private ArrayList<Result> events= new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        //this is absolutely not professional. but its what i know so far.
        events = new ArrayList<Result>(); // ApiPredictHQ.basicSearch();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        events.add(new Result("this"));
        events.add(new Result("that"));
        HttpSession session = request.getSession();
        session.setAttribute("events",events);
        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("html/Home.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
