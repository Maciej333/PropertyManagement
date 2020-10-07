package rogowski.maciej.property.management.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rogowski.maciej.property.management.dao.AnnouncementRepository;
import rogowski.maciej.property.management.entity.Announcement;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	private AnnouncementRepository  announcementRepository;
	
	@Autowired
	public AnnouncementServiceImpl(AnnouncementRepository  theAnnouncementRepository) {
		announcementRepository = theAnnouncementRepository; 
	}

	@Override
	public List<Announcement> getAnnByLessDate() {
		return announcementRepository.getAnnByLessDate(LocalDate.now().toString());
	}

	@Override
	public List<Announcement> getAnnByCurrentDate() {
		return announcementRepository.getAnnByCurrentDate(LocalDate.now().toString());
	}

	@Override
	public List<Announcement> getAllAnn() {
		return announcementRepository.findAll();
	}

	

}
