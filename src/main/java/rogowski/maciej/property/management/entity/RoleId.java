package rogowski.maciej.property.management.entity;

import java.io.Serializable;
import java.util.Objects;

public class RoleId implements Serializable {

	private String username;
	
	private String userRole;
	
	public RoleId() {
		
	}

	public RoleId(String username, String userRole) {
		this.username = username;
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, userRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleId other = (RoleId) obj;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
