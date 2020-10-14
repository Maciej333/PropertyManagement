package rogowski.maciej.property.management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rogowski.maciej.property.management.dao.UserRepository;
import rogowski.maciej.property.management.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}
	
	@Override
	public Integer findMaxId(int propertyId) {
		return userRepository.getMaxUserIdByProperty(propertyId);
	}
	
	@Override
	public List<User> findAllPropertyUsers() {
		return userRepository.findAllPropertyUsers();
	}
	
	@Override
	public User findById(String id) {
		Optional<User> result = userRepository.findById(id);
		User theUser = null;
		if(result.isPresent()) {
			theUser = result.get();
		}
		return theUser;
	}

	@Override
	public List<User> getAllManagersOfProperty(int id) {
		return userRepository.getAllManagersOfProperty(id, "zarząd");
	}
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public void addEnableToOne(String userLogin) {
		userRepository.addEnableToOne(userLogin);
	}

	@Override
	public List<User> searchUserByName(String firstName, String lastName, String propertyId) {
		return userRepository.searchUserByName(firstName, lastName, propertyId);
	}

	@Override
	public List<User> getAllUserOfProperty(int id) {
		return userRepository.getAllManagersOfProperty(id, "%");
	}

}
