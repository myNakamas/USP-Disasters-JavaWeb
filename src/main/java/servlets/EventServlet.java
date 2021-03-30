package servlets;

import models.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EventServlet", value = "/EventServlet")
public class EventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        @SuppressWarnings("unchecked")
        Result r = ((ArrayList<Result>)request.getSession().getAttribute("events")).get(id);
        request.setAttribute("eventTitle",r.getTitle());
        request.setAttribute("eventDescription",r.getDescription());
        request.setAttribute("eventCategory",r.getCategory());
        request.setAttribute("eventLocation",r.getLocation().get(1)+","+r.getLocation().get(0));
        request.setAttribute("eventStart",r.getStart());
        request.setAttribute("eventEnd",r.getEnd());
        request.setAttribute("eventDuration",r.getDuration());
        request.setAttribute("eventTimezone",r.getTimezone());
        request.setAttribute("eventRelevance",r.getRelevance());
        RequestDispatcher view = request.getRequestDispatcher("html/EventDetails.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
