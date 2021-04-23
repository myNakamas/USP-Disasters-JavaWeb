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
        //check if the remember cookie is there, if its valid, and if yes, yeet the user out of this page.
        //otherwise, let him log in
        User user = LoginServlet.checkCookie(request);
        if(user !=null)
        {
            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/");
        }
        else {
            RequestDispatcher view = request.getRequestDispatcher("html/Login.jsp");
            view.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User inputUser = new User();

            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String keepLoggedIn = request.getParameter("keepLoggedIn");

            UserService userService = new UserService();
            if(email!=null){    //Login with google
                User user = userService.findByUsername(username);
                if(user!=null){
                    request.getSession(false).invalidate();
                    request.getSession().setAttribute("user", user);
                }
                else{
                    user = new User(username,null,email,null);
                    userService.persist(user);
                }

            }else {             //Manual login
                inputUser.setUsername(username);
                inputUser.setPassword(password);

                User user = userService.logIn(inputUser);
                if (user != null) {

                    request.getSession(false).invalidate();
                    request.getSession().setAttribute("user", user);

                    if (keepLoggedIn != null) {
                        //If the user has checked the keep me logged in, create a cookie that lasts for a long time and send it to the browser
                        //then check if the cookie id is there and if its correct (the same as in the database), log in the correct user (getting him from the database).
                        UserCookie userCookie = new UserCookie(user, "remember", request.getRemoteAddr());
                        //we are getting the ip just to check if its from the same device.
                        UserCookieService cookieService = new UserCookieService();
                        cookieService.persist(userCookie);
                        Cookie rememberCookie = new Cookie("remember", Long.toString(userCookie.getCookie_id()));
                        rememberCookie.setMaxAge(60 * 60 * 24 * 365); //one year
                        response.addCookie(rememberCookie);
                    }
                    response.sendRedirect(request.getContextPath() + "/");

                } else throw new Exception("Username or password are incorrect!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error",e.getMessage());
            //refresh the page
            doGet(request, response);
        }
    }

    static User checkCookie(HttpServletRequest request) {
        User user = null;
        for(Cookie cookie : request.getCookies())
        {
            if(cookie.getName().equals("remember"))
            {
                UserCookieService cookieService = new UserCookieService();
                user = cookieService.checkCookie(cookie.getValue(),request.getRemoteAddr());
                break;
            }
        }
        return user;
    }
}


