package rogowski.maciej.property.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rogowski.maciej.property.management.entity.Announcement;
import rogowski.maciej.property.management.entity.Property;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

	@Query(value = "SELECT * FROM announcement a WHERE a.property_id = ?1 AND a.date_to < DATE(?2) ORDER BY a.id DESC", nativeQuery = true)
	public List<Announcement> getAnnByLessDate(int id, String searchDate);

	@Query(value = "SELECT * FROM announcement a WHERE a.property_id = ?1 AND a.date_to >= DATE(?2) AND a.date_from <= DATE(?2) ORDER BY a.id DESC", nativeQuery = true)
	public List<Announcement> getAnnByCurrentDate(int id, String searchDate);

	public List<Announcement> findAllByPropertyOrderByIdDesc(Property property);

	public List<Announcement> findByProperty(Property property);
}
