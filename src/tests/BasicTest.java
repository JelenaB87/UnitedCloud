package tests;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.ChooseProfilePage;
import pages.CreateProfilePage;
import pages.LoginPage;
import pages.ProfilePage;

public abstract class BasicTest {
	protected WebDriver driver;
	protected LoginPage logInPage;
	protected ChooseProfilePage chooseProfilePage;
	protected CreateProfilePage createProfilePage;
	protected ProfilePage profilePage;
	protected String pageUrl = "https://qa-interview.united.cloud";
	protected String username = "jelena.bozinovic";
	protected String password = "Lozinka123";

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver2.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pageUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		logInPage = new LoginPage(driver);
		chooseProfilePage = new ChooseProfilePage(driver);
		createProfilePage = new CreateProfilePage(driver);
		profilePage = new ProfilePage(driver);

	}

	@AfterMethod
	public void cleanup() {
		this.driver.quit();
	}
}
