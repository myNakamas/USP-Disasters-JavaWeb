package servlets;

import models.entities.User;
import services.UserService;
import shared.Email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "LostDataServlet")
public class LostDataServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("html/LostData.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String recipient = request.getParameter("email");
        User u;
        UserService us = new UserService();

        try{
            u = us.findByEmail(recipient);
            if(u == null) {
                throw new Exception("An account with such email does not exist!");
            }
            else {
                Email.sendEmailLostData(request, recipient, u);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error",e.getMessage());
        }
        doGet(request, response);
    }




}
