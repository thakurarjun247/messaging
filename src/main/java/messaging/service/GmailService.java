package messaging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GmailService implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(GmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

/*    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;*/

    @Value("${spring.mail.username}")
    private String senderEmail;



    @Override
    public void sendSimpleEmail(String receiverEmail, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(senderEmail);  // Use your email as the sender
            message.setTo(receiverEmail);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
            logger.info("Email sent successfully to {}", receiverEmail);
        } catch (Exception e) {
            logger.error("Failed to send email to {}", receiverEmail, e);
        }
    }
}
