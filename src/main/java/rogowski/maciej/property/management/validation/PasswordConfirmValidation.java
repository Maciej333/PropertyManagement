package rogowski.maciej.property.management.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import rogowski.maciej.property.management.entity.UserPasswordModel;

public class PasswordConfirmValidation implements ConstraintValidator<PasswordMatch, Object> {

	@Override
	public void initialize(PasswordMatch constraintAnnotation) {

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		UserPasswordModel upm = (UserPasswordModel) value;	
		if( (upm.getNewPassword()!=null) && (upm.getConfirmNewPassword()!=null) ) {
			return (upm.getNewPassword()).equals(upm.getConfirmNewPassword());
		}
		return true;
	}

}
