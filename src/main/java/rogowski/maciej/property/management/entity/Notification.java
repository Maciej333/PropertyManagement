package rogowski.maciej.property.management.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="notification")
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="title cannot be empty")
	@Column(name="title")
	private String title;
	
	@Column(name="send_date")
	private LocalDate sendDate;
	
	@OneToOne
	@JoinColumn(name="sender")
	private User sender;
	
	@OneToOne
	@JoinColumn(name="receiver")
	private User receiver;
	
	@OneToOne
	@JoinColumn(name="new_to")
	private User newTO;
	
	@NotNull(message="text cannot be empty")
	@Column(name="notification_text")
	private String notificationText;
	
	@OneToOne
	@JoinColumn(name="response_to_id")
	private Notification notification;
	
	public Notification() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public User getNewTO() {
		return newTO;
	}

	public void setNewTO(User newTO) {
		this.newTO = newTO;
	}

	public String getNotificationText() {
		return notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	
}
