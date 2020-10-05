package rogowski.maciej.property.management.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rogowski.maciej.property.management.dao.PropertyRepository;
import rogowski.maciej.property.management.entity.Property;

@Service
public class PropertyServiceImpl implements PropertyService {

	private PropertyRepository propertyRepository;
	
	@Autowired
	public PropertyServiceImpl(PropertyRepository thePropertyRepository) {
		propertyRepository = thePropertyRepository;
	}
	
	@Override
	public Property findById(int id) {
		Optional<Property> result = propertyRepository.findById(id);
		Property thePropertie = null;
		if(result.isPresent()) {
			thePropertie = result.get();
		}
		return thePropertie;
	}

}
