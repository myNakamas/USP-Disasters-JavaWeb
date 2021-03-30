package servlets;

import models.entities.User;
import models.entities.UserCookie;
import services.UserCookieService;
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

        //check if the remember cookie is there, if its valid, and if yes, yeet the user out of this page.
        //otherwise, let him log in

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String keepLoggedIn = request.getParameter("keepLoggedIn");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserService userService = new UserService();
        user = userService.logIn(user);
            if(user!=null) {
                request.getSession().setAttribute("user",user);
                if(keepLoggedIn.equals("on")) {
                    //If the user has checked the keep me logged in, create a cookie that lasts for a long time and send it to the browser
                    //then check if the cookie id is there and if its correct (the same as in the database), log in the correct user (getting him from the database).
                    UserCookie userCookie = new UserCookie(user,"remember", request.getRemoteAddr());
                    //we are getting the ip just to check if its from the same device.
                    UserCookieService cookieService = new UserCookieService();
                    cookieService.persist(userCookie);      //FIXME: error:userId doesnt have a default value?
                   // UserCookie rememberCookie = new Cookie("remember", Long.toString(userCookie.getCookie_id()));
                   // response.addCookie(rememberCookie);
                }
                response.sendRedirect(request.getContextPath()+"/");
            }
            else throw new Exception("Username or password are incorrect!");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error",e.getMessage());
            //refresh the page
            doGet(request, response);
        }
    }
}
