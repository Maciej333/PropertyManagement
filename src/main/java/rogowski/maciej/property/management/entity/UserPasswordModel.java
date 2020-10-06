package rogowski.maciej.property.management.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserPasswordModel {

	@NotBlank(message="old password is required")
	private String oldPassword;
	
	@NotBlank(message="new password is required")
	@NotNull(message="password cannot be empty")
	@Min(value=6, message="password must be at least 6 char length")
	private String newPassword;
	
	@NotBlank(message="new password is required")
	@NotNull(message="password cannot be empty")
	@Min(value=6, message="password must be at least 6 char length")
	private String confirmNewPassword;
	
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
	
}
