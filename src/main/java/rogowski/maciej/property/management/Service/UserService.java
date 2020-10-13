package rogowski.maciej.property.management.Service;

import java.util.List;

import rogowski.maciej.property.management.entity.User;

public interface UserService {
	
	public List<User> findAllPropertyUsers();
	
	public User findById(String id);
	
	public List<User> getAllManagersOfProperty(int id);
	
	public void save(User user);
	
	public void delete(User user);
}
