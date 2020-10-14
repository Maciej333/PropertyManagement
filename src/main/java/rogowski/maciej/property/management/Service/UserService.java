package rogowski.maciej.property.management.Service;

import java.util.List;

import rogowski.maciej.property.management.entity.User;

public interface UserService {
	
	public Integer findMaxId(int propertyId);
	
	public List<User> findAllPropertyUsers();
	
	public User findById(String id);
	
	public List<User> getAllManagersOfProperty(int id);
	
	public void save(User user);
	
	public void delete(User user);
	
	public void addEnableToOne(String userLogin);
	
	public List<User> searchUserByName(String firstName, String lastName, String propertyId);
	
	public List<User> getAllUserOfProperty(int id);
}
