package rogowski.maciej.property.management.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import rogowski.maciej.property.management.validation.PasswordMatch;

@PasswordMatch
public class UserPasswordModel {

	@NotBlank(message="old password is required")
	private String oldPassword;
	
	@NotBlank(message="new password is required")
	@Pattern(regexp = "[\\w|\\.|!]{6,}", message="password must be at least 6 char length, can contain letters, digits, _ , . or !")
	private String newPassword;
	
	private String confirmNewPassword;
	
	private String confirmOldPassword;
	
	public UserPasswordModel() {
		
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public String getConfirmOldPassword() {
		return confirmOldPassword;
	}

	public void setConfirmOldPassword(String confirmOldPassword) {
		this.confirmOldPassword = confirmOldPassword;
	}

}
