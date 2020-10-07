package rogowski.maciej.property.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rogowski.maciej.property.management.entity.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

	@Query(value = "SELECT * FROM announcement a WHERE a.date_to < DATE(?1)", nativeQuery = true )
	public List<Announcement> getAnnByLessDate(String searchDate);
	
	@Query(value = "SELECT * FROM announcement a WHERE a.date_to >= DATE(?1) AND a.date_from <= DATE(?1)", nativeQuery = true )
	public List<Announcement> getAnnByCurrentDate(String searchDate);

}
