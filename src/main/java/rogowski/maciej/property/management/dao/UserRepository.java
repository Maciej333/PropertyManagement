package rogowski.maciej.property.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rogowski.maciej.property.management.entity.User;


public interface UserRepository extends JpaRepository<User, String> {

}
