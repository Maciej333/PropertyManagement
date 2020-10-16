package rogowski.maciej.property.management.Service;

import java.util.List;
import java.util.Optional;

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
	public List<Notification> getUserNewNotification(String newTO, String sender, String receiver) {
		return notificationRepository.findUserNewNotification(newTO, sender, receiver);
	}

	@Override
	public List<Notification> getUserSendNotification(String sender, String receiver) {
		return notificationRepository.findUserSendNotification(sender, receiver);
	}
	
	@Override
	public List<Notification> getUserNotification(String sender, String receiver) {
		return notificationRepository.findUserNotification(sender, receiver);
	}

	@Override
	public List<Notification> getResponseNotification(int responseId) {
		return notificationRepository.findResponseNotification(responseId);
	}
	
	@Override
	public Notification findById(Integer id) {
		Notification notification = null;
		Optional<Notification> optNotification = notificationRepository.findById(id);
		if(optNotification.isPresent()) {
			notification = optNotification.get();
		}
		return notification;
	}

	@Override
	public void save(Notification notification) {
		notificationRepository.save(notification);
	}
}
