package servlets;



import models.entities.User;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet(name = "LostDataServlet", value = "/LostDataServlet")
public class LostDataServlet extends HttpServlet {

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
        //this displays the html on the page
    }

    public static void sendEmail(String host, String port,
                                 final String senderEmail, String senderName, final String password,
                                 String recipientEmail, String subject, String message) throws AddressException,
            MessagingException, UnsupportedEncodingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.protocol", "smtp");

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String recipient = request.getParameter("email");
        User u = new User();
        UserService us = new UserService();

        try{
            u = us.findByEmail(recipient);
            if(u == null) {
                throw new Exception("An account with such email does not exist!");
            }
            String subject = "Here is your user data from Disasters Worldwide!";

            String content = "Hi, this is your username : " + u.getUsername();
            content += " and this is your password : " + u.getPassword();
            content += "\nNote: for security reasons, "
                    + "please change your password after logging in.";

            sendEmail(host, port, email, name, pass,
                    recipient, subject, content);
            throw new Exception( "Your information has been sent. Please check your e-mail.");

        }
        catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error",e.getMessage());
            //refresh the page
            doGet(request, response);
        }
    }
}
