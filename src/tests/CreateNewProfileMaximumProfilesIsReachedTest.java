package tests;

import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class CreateNewProfileMaximumProfilesIsReachedTest extends BasicTest {
	public String loginForm = pageUrl + "/login";
	public String nameProfile1 = "NAME1 - " + RandomString.make();
	public String nameProfile2 = "NAME2 - " + RandomString.make();
	public String nameProfile3 = "NAME3 - " + RandomString.make();
	public String nameProfile4 = "NAME4 - " + RandomString.make();
	public String nameProfile5 = "NAME5 - " + RandomString.make();
	public String nameProfile6 = "NAME6 - " + RandomString.make();
	public int age = 8;
	public String yearOfBirth = "";

	@Test
	public void createNewProfileMaximumProfilesIsReached() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.logInPage.logIn(this.username, this.password);
		Thread.sleep(500);
		// One profile
		this.chooseProfilePage.createNewProfile();
		this.createProfilePage.inputName(nameProfile1);
		Thread.sleep(500);
		this.createProfilePage.chooseAge(age);
		Thread.sleep(1500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		Thread.sleep(500);
		this.createProfilePage.createProfile();
		Thread.sleep(500);
		// Two profile
		this.profilePage.createNewProfile();
		this.createProfilePage.inputName(nameProfile2);
		Thread.sleep(500);
		this.createProfilePage.chooseAge(age);
		Thread.sleep(1500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		Thread.sleep(1500);
		this.createProfilePage.createProfile();
		// Three profile
		Thread.sleep(500);
		this.profilePage.createNewProfile();
		this.createProfilePage.inputName(nameProfile3);
		Thread.sleep(500);
		this.createProfilePage.chooseAge(age);
		Thread.sleep(1500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		Thread.sleep(1500);
		this.createProfilePage.createProfile();
		// Four profile
		Thread.sleep(500);
		this.profilePage.createNewProfile();
		this.createProfilePage.inputName(nameProfile4);
		Thread.sleep(500);
		this.createProfilePage.chooseAge(age);
		Thread.sleep(1500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		this.createProfilePage.createProfile();
		// Five profile
		Thread.sleep(500);
		this.profilePage.createNewProfile();
		this.createProfilePage.inputName(nameProfile5);
		Thread.sleep(500);
		this.createProfilePage.chooseAge(age);
		Thread.sleep(1500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		Thread.sleep(1500);
		this.createProfilePage.createProfile();
		// Six profile
		Thread.sleep(500);
		this.profilePage.createNewProfile();
		this.createProfilePage.inputName(nameProfile6);
		Thread.sleep(500);
		this.createProfilePage.chooseAge(age);
		Thread.sleep(1500);
		this.createProfilePage.chooseAvatar(age, yearOfBirth);
		Thread.sleep(1500);
		this.createProfilePage.createProfile();
		this.createProfilePage.validateIsMaximumNumberOfProfileIsReached();

	}

}
