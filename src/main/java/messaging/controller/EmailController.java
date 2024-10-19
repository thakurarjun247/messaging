package messaging.controller;

import messaging.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
curl -X POST http://localhost:8084/sendEmail \
        -d "receiverEmail=thakurarjun247@gmail.com" \
        -d "subject=Test Subject" \
        -d "text=This is a test email message." \
        -H "Content-Type: application/x-www-form-urlencoded"

        */

@RestController
public class EmailController {


    @Autowired
    private EmailService emailService;

    // Endpoint to send an email
    @PostMapping("/sendEmail")
    public String sendEmail(
            @RequestParam("receiverEmail") String receiverEmail,
            @RequestParam("subject") String subject,
            @RequestParam("text") String text) {
        emailService.sendSimpleEmail(receiverEmail, subject, text);
        return "Email sent successfully!";
    }
}
