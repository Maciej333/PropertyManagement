package rogowski.maciej.property.management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rogowski.maciej.property.management.dao.RoleRepository;
import rogowski.maciej.property.management.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository theRoleRepository) {
		roleRepository = theRoleRepository;
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

}
