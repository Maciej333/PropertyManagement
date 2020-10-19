package rogowski.maciej.property.management.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import rogowski.maciej.property.management.entity.Announcement;

public class DateAnnouncementValidation implements ConstraintValidator<DateAnnouncement, Object> {

	@Override
	public void initialize(DateAnnouncement constraintAnnotation) {

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Announcement announcement = (Announcement) value;
		if (announcement.getDateFrom() != null && announcement.getDateTo() != null
				&& (announcement.getDateFrom().isBefore(announcement.getDateTo())
						|| announcement.getDateFrom().isEqual(announcement.getDateTo()))) {
			return true;
		} else {
			return false;
		}
	}

}
