package tests;

import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class CreateNewProfileWithAgeRange18PlusTest extends BasicTest {
	public String loginForm = pageUrl + "/login";
	public String nameProfile = "NAME - " + RandomString.make();
	public int age = 34;
	public String yearOfBirth = "1987";

	@Test
	public void createNewProfileWithAgeRange18Plus() throws InterruptedException {
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
