package rogowski.maciej.property.management.Service;

import java.util.List;

import rogowski.maciej.property.management.entity.Announcement;

public interface AnnouncementService {

	public List<Announcement> getAnnByLessDate();
	
	public List<Announcement> getAnnByCurrentDate();
	
	public List<Announcement> getAllAnn();
}
