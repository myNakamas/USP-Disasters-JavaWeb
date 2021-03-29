package servlets;

import models.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("html/Register.jsp");
        view.forward(request, response);
        //this displays the html on the page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String phone = request.getParameter("phone");

        try {
            if(username.equals("")||email.equals("")||password.equals("")|| password2.equals("")||phone.equals("")) throw new Exception("Fill all the fields!");
            //TODO: all the verifications

            //TODO: Check for the username in the database

            User user = new User(username,password,email,phone);

            UserService userService= new UserService();
            userService.persist(user);

            response.sendRedirect(request.getContextPath()+"/Login");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            request.setAttribute("error",e.getMessage());
            //refresh the page
            response.sendRedirect(request.getContextPath()+"/Register");
        }
    }
}
