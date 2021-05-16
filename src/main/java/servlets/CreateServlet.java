package servlets;

import api.ApiPredictHQ;
import models.entities.Disaster;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.entities.User;
import services.DisasterService;
import services.UserService;
import shared.Email;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@WebServlet(name = "CreateServlet", value = "/CreateServlet")
public class CreateServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("html/CreateDisaster.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String desc = request.getParameter("desc");
        String country = request.getParameter("country");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String category = "disasters";
        String countryCode = "";

        try {
            DisasterService disasterService = new DisasterService();
            if (title.equals("") || desc.equals("") || start.equals("") || end.equals("") || !country.contains(":")) {
                throw new IOException("Some fields are empty or the input is wrong!");
            }

            if (!country.isBlank()) {
                countryCode = country.substring(country.indexOf(':') + 1);
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date Start = format.parse(start);
            Date End = format.parse(end);

            File myFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("locations.txt")).getFile());
            Scanner myReader = new Scanner(myFile);
            String line = " ";
            while (myReader.hasNextLine() && !line.equals(countryCode)) {
                line = myReader.nextLine();
            }
            line = myReader.nextLine();
            String loc = line + ",";
            line = myReader.nextLine();
            loc = loc + line ;

            Disaster elem = new Disaster(title, desc,category, Start, End, countryCode, loc);
            disasterService.persist(elem);
            myReader.close();

            List<User> users = userService.findAll();
            for (User u: users) {
                Email.sendEmailNewDisaster(u.getEmail(), elem);
            }

            response.sendRedirect(request.getContextPath() + "/");
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("html/CreateDisaster.jsp").forward(request, response);
        }
    }
}

