package rogowski.maciej.property.management.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import rogowski.maciej.property.management.validation.DateAnnouncement;

@Entity
@Table(name = "announcement")
@DateAnnouncement
public class Announcement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "property_id")
	private Property property;

	@Column(name = "title")
	@NotEmpty(message = "Cannot be empty")
	private String title;

	@Column(name = "date_from")
	@NotNull(message = "date cannot be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFrom;

	@Column(name = "date_to")
	@NotNull(message = "date cannot be null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateTo;

	@Column(name = "announcement_text")
	@NotEmpty(message = "Cannot be empty")
	private String announcementText;

	public Announcement() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
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
