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
        events = ApiPredictHQ.basicSearch();//new ArrayList<Result>();
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
