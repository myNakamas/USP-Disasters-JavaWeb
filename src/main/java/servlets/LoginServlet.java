package servlets;

import models.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("html/Login.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserService userService = new UserService();

            if(userService.logIn(user)!=null) {
                request.getSession().setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/");
            }
            else throw new Exception("Username or password are incorrect!");

        } catch (Exception e) {
            e.printStackTrace();        //Todo: dipslay the error to the user.
            request.setAttribute("error",e.getMessage());
            RequestDispatcher view = request.getRequestDispatcher("/");
            view.forward(request, response);
        }
    }
}
