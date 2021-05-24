package shared;

import models.entities.Disaster;
import models.entities.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public final class Email {
    private static String host = "smtp.gmail.com";
    private static String port = "587";
    private static String email = "disastersinformation@gmail.com";
    private static String name = "USP -Disasters";
    private static String pass = "disaster.123";

    private static void sendEmail(String host, String port, final String senderEmail, String senderName, final String password,
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


    public static void sendEmailNewDisaster( String recipient, Disaster disaster) throws MessagingException, UnsupportedEncodingException {
        String subject = "WARNING!! New Disaster!";

        String content = "A new disaster has been detected! \n" +
                disaster.getTitle() +"\n" +
                "in " + disaster.getCountry() + "\n" +
                disaster.getDescription() +
                "More information in here > http://localhost:8080/USP_Disasters_JavaWeb_war_exploded/EventDetails?id="+ disaster.getId();
        sendEmail(host, port, email, name, pass, recipient, subject, content);
    }

    public static void sendEmailLostData(HttpServletRequest request, String recipient, User u) throws MessagingException, UnsupportedEncodingException {
        String subject = "Here is your user data from Disasters Worldwide!";

        String content = "Hi ! A request has been sent to retrieve information about your email. If it wasn't from you, please ignore this message." +
                "\n Note: for security reasons, please change your password after logging in." +
                "\nUsername: " + u.getUsername() +
                "\nPassword: " + u.getPassword() + "\n";
        sendEmail(host, port, email, name, pass, recipient, subject, content);
        request.setAttribute("error","Your information has been sent. Please check your email.");
    }

}
