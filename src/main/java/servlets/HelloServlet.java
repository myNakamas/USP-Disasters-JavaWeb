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
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("</body></html>");

        //or, dispatch to an existing resource (servlet, jsp etc.) (called forwarding to a view)
        RequestDispatcher view = request.getRequestDispatcher("html/myPage.html");
        view.forward(request, response);
    }

    public void destroy() {
    }
}