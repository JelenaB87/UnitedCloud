package tests;

import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class CreateNewProfileWithOutMandatoryFieldsTest extends BasicTest {

	public String loginForm = pageUrl + "/login";
	public String nameProfile = "NAME - " + RandomString.make();

	@Test
	public void createNewProfileWithOutMandatoryFields() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.logInPage.logIn(this.username, this.password);
		this.chooseProfilePage.createNewProfile();
		this.createProfilePage.inputName(nameProfile);
		Thread.sleep(1500);
		this.createProfilePage.createProfile();
		Thread.sleep(500);
		this.createProfilePage.validateIsProfileCantCreateWithoutMandatoryFields();
	}
}
