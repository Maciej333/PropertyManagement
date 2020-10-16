package rogowski.maciej.property.management.Service;

import java.util.List;

import rogowski.maciej.property.management.entity.Notification;

public interface NotificationService {

	public List<Notification> getUserNewNotification(String newTO, String sender, String receiver);
	
	public List<Notification> getUserSendNotification(String sender, String receiver);
	
	public List<Notification> getUserNotification(String sender, String receiver);
	
	public List<Notification> getResponseNotification(int responseId);
	
	public Notification findById(Integer id);
	
	public void save(Notification notification);
}
