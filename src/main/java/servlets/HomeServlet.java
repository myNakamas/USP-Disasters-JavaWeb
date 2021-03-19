package servlets;

import com.google.firebase.FirebaseApp;
import json.ApiPredictHQ;
import json.models.Result;
import json.FirebaseConfig;

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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //  events = ApiPredictHQ.basicSearch();
        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("html/index.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
