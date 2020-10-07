package rogowski.maciej.property.management.Service;

import java.util.List;

import rogowski.maciej.property.management.entity.User;

public interface UserService {
	
	public User findById(String id);

	public void save(User user);
	
	public List<User> getAllManagersOfProperty(int id);
}
