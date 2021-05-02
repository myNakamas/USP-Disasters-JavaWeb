package servlets;

import models.entities.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Serial;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet(name = "LostDataServlet")
public class LostDataServlet extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name = context.getInitParameter("name");
        pass = context.getInitParameter("pass");
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
                String subject = "Here is your user data from Disasters Worldwide!";

                String content = "Hi ! A request has been sent to retrieve information about your email. If it wasn't from you, please ignore this message." +
                        "\n Note: for security reasons, please change your password after logging in." +
                        "\nUsername: " + u.getUsername() +
                        "\nPassword: " + u.getPassword() + "\n";
                sendEmail(host, port, email, name, pass, recipient, subject, content);
                request.setAttribute("success","Your information has been sent. Please check your email.");
                //Todo: For Marti:  find a way to display those messages on the screen

                //refresh the page
                doGet(request, response);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error",e.getMessage());
            //refresh the page
            doGet(request, response);
        }
    }

    public static void sendEmail(String host, String port, final String senderEmail, String senderName, final String password,
                                 String recipientEmail, String subject, String message) throws
            MessagingException, UnsupportedEncodingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(senderEmail, senderName));
        InternetAddress[] toAddresses = { new InternetAddress(recipientEmail) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);

        // sends the e-mail
        Transport.send(msg);
    }
}
