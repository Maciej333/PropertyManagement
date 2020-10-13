package rogowski.maciej.property.management.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rogowski.maciej.property.management.entity.User;


public interface UserRepository extends JpaRepository<User, String> {
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET enabled = 1 WHERE username = :login", nativeQuery = true)
	public void addEnableToOne(@Param(value = "login") String login);
	
	@Query(value="SELECT MAX(CAST((REGEXP_SUBSTR(username, '[0-9]+')) AS UNSIGNED )) FROM user WHERE username != 'admin1' AND property_id = ?1", nativeQuery = true)
	public Integer getMaxUserIdByProperty(int propertyId);
	
	@Query(value="SELECT * FROM user WHERE (ISNULL(property_id ) != true)", nativeQuery = true)
	public List<User> findAllPropertyUsers();
	
	@Query(value="SELECT * FROM user WHERE property_id = ?1 AND user_property_role = ?2", nativeQuery = true)
	public List<User> getAllManagersOfProperty(int id, String role);
}
