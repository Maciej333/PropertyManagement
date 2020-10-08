package rogowski.maciej.property.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rogowski.maciej.property.management.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	@Query(value = "SELECT * FROM notification n WHERE n.new_to =?1 ORDER BY n.id DESC", nativeQuery = true)
	public List<Notification> findUserNewNotification(String receiver);
	
	@Query(value = "SELECT * FROM notification n WHERE n.sender=?1 AND ISNULL(n.response_to_id) ORDER BY n.id DESC", nativeQuery = true)
	public List<Notification> findUserSendNotification(String sender);	
	
	@Query(value = "SELECT * FROM notification n WHERE (n.sender=?1 OR n.receiver=?2) AND ISNULL(n.response_to_id) ORDER BY n.id DESC", nativeQuery = true)
	public List<Notification> findUserNotification(String sender, String receiver);
	
	@Query(value = "SELECT * FROM notification n WHERE n.response_to_id = ?1", nativeQuery = true )
	public List<Notification> findResponseNotification(int responseId);
}
