package servlets;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // To display something on the Screen you either

        //Write your HTML code like this:
        PrintWriter out = response.getWriter();
        out.println("<html><body>This works");
        out.println("</body></html>");

        //or, dispatch to an existing resource (servlet, jsp etc.) (called forwarding to a view)
        //forwarding will not change the URL
//        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//        view.forward(request, response);

        //while on the other hand, you can just redirect the user.
        //this changes the URL
        //response.sendRedirect(request.getContextPath() +"/dashboard.jsp");
    }

    public void destroy() {
    }
}