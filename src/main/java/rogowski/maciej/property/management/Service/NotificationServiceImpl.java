package rogowski.maciej.property.management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rogowski.maciej.property.management.dao.NotificationRepository;
import rogowski.maciej.property.management.entity.Notification;

@Service
public class NotificationServiceImpl implements NotificationService {

	private NotificationRepository notificationRepository;
	
	@Autowired
	public NotificationServiceImpl(NotificationRepository theNotificationRepository) {
		notificationRepository = theNotificationRepository;
	}

	@Override
	public List<Notification> getUserNotification(String sender, String receiver) {
		return notificationRepository.findUserNotification(sender, receiver);
	}

	@Override
	public List<Notification> getResponseNotification(int responseId) {
		return notificationRepository.findResponseNotification(responseId);
	}

}
