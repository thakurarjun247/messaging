package messaging.service;

public interface EmailService {
     void sendSimpleEmail(String receiverEmail, String subject, String text);
}
