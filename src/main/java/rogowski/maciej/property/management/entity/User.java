package rogowski.maciej.property.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="username")
	private String login;
	
	@Column(name="user_password")
	private String password;
	
	@Pattern(regexp = "[A-Z][a-z]{2,}", message = "{user.name}")
	@Column(name="first_name")
	private String firstName;
	
	@Pattern(regexp = "[A-Z][a-z]{2,}", message = "{user.name}")
	@Column(name="last_name")
	private String lastName;
	
	@Min(value=100000000, message="{user.nine}")
	@Max(value=999999999, message="{user.nine}")
	@Column(name="phone_number")
	private int number;
	
	@ManyToOne
	@JoinColumn(name="property_id")
	private Property property;
	
	@Min(value=1, message="must be a positive number")
	@Column(name="apartment_number")
	private int apartmentNumber;

    public User() {
    	
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

}
