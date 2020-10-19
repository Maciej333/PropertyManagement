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

	@Query(value = "SELECT MAX(CAST((REGEXP_SUBSTR(username, '[0-9]+')) AS UNSIGNED )) FROM user WHERE username != 'admin1' AND property_id = ?1", nativeQuery = true)
	public Integer getMaxUserIdByProperty(int propertyId);

	@Query(value = "SELECT * FROM user WHERE (ISNULL(property_id ) != true)", nativeQuery = true)
	public List<User> findAllPropertyUsers();

	@Query(value = "SELECT * FROM user WHERE property_id = ?1 AND user_property_role LIKE ?2", nativeQuery = true)
	public List<User> getAllManagersOfProperty(int id, String role);

	@Query(value = "SELECT * FROM user WHERE ((first_name LIKE ?1 OR last_name LIKE ?1) AND property_id IS NOT NULL) AND property_id LIKE ?3 UNION "
			+ "SELECT * FROM user WHERE ((first_name LIKE ?1 AND last_name LIKE ?2) OR (first_name LIKE ?2 AND last_name LIKE ?1)) AND property_id IS NOT NULL AND property_id LIKE ?3", nativeQuery = true)
	public List<User> searchUserByName(String firstName, String lastName, String propertyId);

}
