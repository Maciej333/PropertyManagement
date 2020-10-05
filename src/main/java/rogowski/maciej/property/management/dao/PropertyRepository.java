package rogowski.maciej.property.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rogowski.maciej.property.management.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
