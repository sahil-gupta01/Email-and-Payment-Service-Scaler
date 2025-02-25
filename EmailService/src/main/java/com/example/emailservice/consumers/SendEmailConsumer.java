package com.example.emailservice.consumers;

import com.example.emailservice.dtos.SendEmailMessageDto;
import com.example.emailservice.services.EmailUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
public class SendEmailConsumer {

    @Autowired
    private ObjectMapper objectMapper;
    private String USER_EMAIL;
    private String USER_PASSWORD;

    @Autowired
    public SendEmailConsumer(ObjectMapper objectMapper,@Value("${gmail.user.email}") String email,@Value("${gmail.user.password}") String password) {
        this.objectMapper = objectMapper;
        this.USER_EMAIL = email;
        this.USER_PASSWORD = password;
    }

    @KafkaListener(
            topics = {"sendEmail"},
            id = "emailServiceConsumerGroup"
    )
    public void handleSendEmail(String message){

        System.out.println("handeSenderEMail called");
        SendEmailMessageDto messageDto;
        try {
            messageDto  = objectMapper.readValue(message, SendEmailMessageDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(messageDto.getTo() + "  " + messageDto.getFrom());

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER_EMAIL, USER_PASSWORD);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, messageDto.getTo(), messageDto.getSubject(), messageDto.getBody());
    }
}
