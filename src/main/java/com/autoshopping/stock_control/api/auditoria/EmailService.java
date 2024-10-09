package com.autoshopping.stock_control.api.auditoria;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import java.util.Properties;

public class EmailService {

    public static void  enviarEmail(String to, String subject, String body) throws MessagingException{
        final String username = "tec.informacao@autoshopping.com.br";
        final String password = "Santos@2201";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "mail.aspago.com.br");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, password);
            }

        });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject((subject));
            message.setText(body);

            Transport.send(message);

            System.out.println("Email enviado com sucesso!");


        }catch (MessagingException e){
            System.err.println("Erro ao enviar email: "+ e.getMessage());
            e.printStackTrace();
        }
    }

}
