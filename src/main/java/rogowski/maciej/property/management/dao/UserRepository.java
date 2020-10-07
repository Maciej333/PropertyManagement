package rogowski.maciej.property.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rogowski.maciej.property.management.entity.User;


public interface UserRepository extends JpaRepository<User, String> {

	
	@Query(value="SELECT * FROM user WHERE property_id = ?1 AND user_property_role = ?2", nativeQuery = true)
	public List<User> getAllManagersOfProperty(int id, String role);
}
