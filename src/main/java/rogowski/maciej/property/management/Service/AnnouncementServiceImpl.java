package rogowski.maciej.property.management.Service;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rogowski.maciej.property.management.dao.AnnouncementRepository;
import rogowski.maciej.property.management.entity.Announcement;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	private Log logger = LogFactory.getLog(this.getClass());
	
	private AnnouncementRepository  announcementRepository;
	
	@Autowired
	public AnnouncementServiceImpl(AnnouncementRepository  theAnnouncementRepository) {
		announcementRepository = theAnnouncementRepository; 
	}

	@Override
	public List<Announcement> getAnnByLessDate() {
		List<Announcement> annList= announcementRepository.getAnnByLessDate(LocalDate.now().toString());
		
		for(Announcement a: annList) {
			logger.info("==================== Wczytano "+a.getTitle());
		}
		
		return annList;
	}
	

}
