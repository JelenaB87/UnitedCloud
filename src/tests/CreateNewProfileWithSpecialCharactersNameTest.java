package tests;

import org.testng.annotations.Test;

public class CreateNewProfileWithSpecialCharactersNameTest extends BasicTest {

	public String loginForm = pageUrl + "/login";
	public String nameProfile = "@@@!!!";
	public int age = 14;
	public String yearOfBirth = "1987";

	@Test
	public void createNewProfileWithSpecialCharactersName() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.logInPage.logIn(this.username, this.password);
		Thread.sleep(500);
		this.chooseProfilePage.createNewProfile();
		Thread.sleep(1500);
		this.createProfilePage.inputName(nameProfile);
		Thread.sleep(500);
		this.createProfilePage.chooseAge(age);
		Thread.sleep(1500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		Thread.sleep(1500);
		this.createProfilePage.createProfile();
		this.createProfilePage.validateIsProfileSuccessfullCreated(nameProfile);
	}

}
