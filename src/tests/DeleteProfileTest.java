package tests;

import org.testng.annotations.Test;

public class DeleteProfileTest extends BasicTest {
	public String loginForm = pageUrl + "/login";
	public String nameProfile = "ForDelete";
	public String existNameProfile = "NAME";
	public int age = 14;
	public String yearOfBirth = "";

	@Test
	public void deleteProfile() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.logInPage.logIn(this.username, this.password);

		/*
		 * this.chooseProfilePage.chooseProfile(existNameProfile);
		 * this.profilePage.deleteProfile(); Thread.sleep(500);
		 * this.profilePage.validateIsProfileSuccessfullDelete(existNameProfile);
		 */
		/*
		 * - Otherwise this would be used, since we would know the name of the profile
		 * we are deleting Since the profile list is constantly changing during testing,
		 * I will delete the profile by first creating one
		 */

		// Create profile
		this.chooseProfilePage.createNewProfile();
		Thread.sleep(1500);
		this.createProfilePage.inputName(nameProfile);
		Thread.sleep(500);
		this.createProfilePage.chooseAge(age);
		Thread.sleep(1500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		Thread.sleep(1500);
		this.createProfilePage.createProfile();

		// Delete profile
		Thread.sleep(1500);
		this.profilePage.deleteProfile();
		Thread.sleep(500);
		this.profilePage.validateIsProfileSuccessfullDelete(nameProfile);
	}

}
