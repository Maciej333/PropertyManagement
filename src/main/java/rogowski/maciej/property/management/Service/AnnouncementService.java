package rogowski.maciej.property.management.Service;

import java.util.List;

import rogowski.maciej.property.management.entity.Announcement;
import rogowski.maciej.property.management.entity.Property;

public interface AnnouncementService {

	public List<Announcement> getAnnByLessDate(int id);
	
	public List<Announcement> getAnnByCurrentDate(int id);
	
	public List<Announcement> getAllAnn(Property property);
}
