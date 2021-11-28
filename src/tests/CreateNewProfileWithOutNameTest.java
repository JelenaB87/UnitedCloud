package tests;

import org.testng.annotations.Test;

public class CreateNewProfileWithOutNameTest extends BasicTest {

	public String loginForm = pageUrl + "/login";
	public int age = 34;
	public String yearOfBirth = "1987";

	@Test
	public void createNewProfileWithOutName() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.logInPage.logIn(this.username, this.password);
		this.chooseProfilePage.createNewProfile();
		this.createProfilePage.chooseAge(age);
		Thread.sleep(500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		this.createProfilePage.createProfile();
		Thread.sleep(500);
		this.createProfilePage.validateIsProfileCantCreateWithoutName();

	}
}
