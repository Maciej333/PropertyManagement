package rogowski.maciej.property.management.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="announcement")
public class Announcement {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="property_id")
	private int propertyId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="date_from")
	private LocalDate dateFrom;
	
	@Column(name="date_to")
	private LocalDate dateTo;
	
	@Column(name="announcement_text")
	private String announcementText;
	
	public Announcement() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public String getAnnouncementText() {
		return announcementText;
	}

	public void setAnnouncementText(String announcementText) {
		this.announcementText = announcementText;
	}
	
}
