package rogowski.maciej.property.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rogowski.maciej.property.management.entity.Role;
import rogowski.maciej.property.management.entity.RoleId;

public interface RoleRepository extends JpaRepository<Role, RoleId> {

}
