package rogowski.maciej.property.management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="property")
public class Property {
	@Id
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="Cannot be empty")
	@Column(name="property_name")
	private String name;
		
	@NotEmpty(message="Cannot be empty")
	@Column(name="address")
    private String address;
	
	@OneToMany(mappedBy="property")
	private List<User> user;
	
	@OneToMany(mappedBy="property")
	private List<Announcement> announcements;
	
	public Property() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}
	
	public List<User> findManagers(){
		List<User> managersList = new ArrayList<>();
		for(User u: user) {
			if(u.getUserPropertyRole().equals("zarząd")) {
				managersList.add(u);
			}
		}
		return managersList;
	}
}
