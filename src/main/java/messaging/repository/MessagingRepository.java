package messaging.repository;


import messaging.entity.Message;
import org.springframework.data.repository.ListCrudRepository;

public interface MessagingRepository extends ListCrudRepository<Message, Integer> {
}
