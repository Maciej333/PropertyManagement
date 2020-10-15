package rogowski.maciej.property.management.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rogowski.maciej.property.management.dao.AnnouncementRepository;
import rogowski.maciej.property.management.entity.Announcement;
import rogowski.maciej.property.management.entity.Property;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	private AnnouncementRepository  announcementRepository;
	
	@Autowired
	public AnnouncementServiceImpl(AnnouncementRepository  theAnnouncementRepository) {
		announcementRepository = theAnnouncementRepository; 
	}

	@Override
	public List<Announcement> getAnnByLessDate(int id) {
		return announcementRepository.getAnnByLessDate(id, LocalDate.now().toString());
	}

	@Override
	public List<Announcement> getAnnByCurrentDate(int id) {
		return announcementRepository.getAnnByCurrentDate(id, LocalDate.now().toString());
	}

	@Override
	public List<Announcement> getAllAnn(Property property){
		return announcementRepository.findAllByPropertyOrderByIdDesc(property);
	}

	@Override
	public void save(Announcement announcement) {
		announcementRepository.save(announcement);
	}

	

}
