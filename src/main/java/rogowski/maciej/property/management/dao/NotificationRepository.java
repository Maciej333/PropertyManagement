package rogowski.maciej.property.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rogowski.maciej.property.management.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	@Query(value = "SELECT * FROM notification n WHERE (n.sender=?1 OR n.receiver=?2) AND ISNULL(n.response_to_id)", nativeQuery = true)
	public List<Notification> findUserNotification(String sender, String receiver);
	
	@Query(value = "SELECT * FROM notification n WHERE n.response_to_id = ?1", nativeQuery = true )
	public List<Notification> findResponseNotification(int responseId);
}
