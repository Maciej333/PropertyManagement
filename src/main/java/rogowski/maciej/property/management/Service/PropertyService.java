package rogowski.maciej.property.management.Service;

import java.util.List;

import rogowski.maciej.property.management.entity.Property;

public interface PropertyService {

	public List<Property> findAll();

	public Property findById(int id);

	public void save(Property property);

	public void delete(Property property);

}
