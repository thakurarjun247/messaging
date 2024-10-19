package messaging.controller;

import messaging.entity.Message;
import messaging.repository.MessagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    MessagingRepository messagingRepository;

    @GetMapping
    public List<Message> getAllMessages() {
        return messagingRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Message> saveEvent(@RequestBody Message message) {
        Message savedMessage = messagingRepository.save(message);
        return ResponseEntity.ok(savedMessage);
    }

}
