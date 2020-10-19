package rogowski.maciej.property.management.entity;

import java.util.List;

public class NotificationModel {

	private Notification notification;

	private List<Notification> notificationResponseList;

	public NotificationModel() {

	}

	public NotificationModel(Notification notification) {
		this.notification = notification;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public List<Notification> getNotificationResponseList() {
		return notificationResponseList;
	}

	public void setNotificationResponseList(List<Notification> notificationResponseList) {
		this.notificationResponseList = notificationResponseList;
	}

}
