package rogowski.maciej.property.management.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="property")
public class Property {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="property_name")
	private String name;
		
	@Column(name="address")
    private String address;
	
	@OneToMany(mappedBy="property")
	private List<User> user;
	
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
	
	
}
