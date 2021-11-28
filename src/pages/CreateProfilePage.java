package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateProfilePage extends BasicPage {
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public CreateProfilePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getName() {
		return driver.findElement(By.id("profile-name"));
	}

	public WebElement getAgeFrom0To6() {
		return driver.findElement(By.xpath(
				"//div[@class='create-profile']//div[@class='form__section']//div[@class='age']//input[@id='AGE_0_6']/ancestor::div[@class='age']/label"));
	}

	public WebElement getAgeFrom7To11() {
		return driver.findElement(By.xpath(
				"//div[@class='create-profile']//div[@class='form__section']//div[@class='age']//input[@id='AGE_7_11']/ancestor::div[@class='age']/label"));
	}

	public WebElement getAgeFrom12To14() {
		return driver.findElement(By.xpath(
				"//div[@class='create-profile']//div[@class='form__section']//div[@class='age']//input[@id='AGE_12_14']/ancestor::div[@class='age']/label"));
	}

	public WebElement getAgeFrom15To17() {
		return driver.findElement(By.xpath(
				"//div[@class='create-profile']//div[@class='form__section']//div[@class='age']//input[@id='AGE_15_17']/ancestor::div[@class='age']/label"));
	}

	public WebElement getAge18plus() {
		return driver.findElement(By.xpath(
				"//div[@class='create-profile']//div[@class='form__section']//div[@class='age']//input[@id='AGE_18_PLUS']/ancestor::div[@class='age']/label"));
	}

	public WebElement getKidAvatar() {
		return driver.findElement(By.xpath(
				"//div[@class='create-profile']//div[@class='form__section']//div[@class='avatar']/input[@id=14]/ancestor::div[@class='avatar']/label"));
	}

	public WebElement getOlderAvatar() {
		return driver.findElement(By.xpath(
				"//div[@class='create-profile']//div[@class='form__section']//div[@class='avatar']/input[@id=22]/ancestor::div[@class='avatar']/label"));
	}

	public WebElement getYearOfBirth() {
		return driver.findElement(By.id("year"));
	}

	public WebElement getCreateBtn() {
		return driver.findElement(By.xpath("//div[@class='create-profile']//button[text()='Create profile']"));
	}

	// Methods for create

	public void inputName(String name) {
		this.getName().clear();
		this.getName().sendKeys(name);
	}

	public void chooseAge(int age) {
		if (age <= 6) {
			this.getAgeFrom0To6().click();
		} else if ((age >= 7) && (age <= 11)) {
			this.getAgeFrom7To11().click();
		} else if ((age >= 12) && (age <= 14)) {
			this.getAgeFrom12To14().click();
		} else if ((age >= 15) && (age <= 17)) {
			this.getAgeFrom15To17().click();
		} else if (age >= 18) {
			this.getAge18plus().click();
		}
	}

	public void chooseAvatar(int age, String year) throws InterruptedException {
		if (age <= 6) {
			this.getKidAvatar().click();
		} else if ((age >= 7) && (age <= 11)) {
			this.getKidAvatar().click();
		} else if ((age >= 12) && (age <= 14)) {
			this.getOlderAvatar().click();
		} else if ((age >= 15) && (age <= 17)) {
			this.getOlderAvatar().click();
		} else if (age >= 18) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("year")));
			this.getYearOfBirth().clear();
			this.getYearOfBirth().sendKeys(year);
			Thread.sleep(300);
			this.getOlderAvatar().click();
		}
	}

	public void createProfile() {
		this.getCreateBtn().click();
	}

	public void validateIsProfileSuccessfullCreated(String name) {
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='home']//div[@class='card']//div[@class='card__description']//h2[text()='" + name
						+ "']")));
	}

	public void validateIsProfileCantCreateWithoutName() {
		String message = driver.findElement(By.id("profile-name")).getAttribute("validationMessage");
		Assert.assertEquals(message, "Please fill out this field.");
	}

	public void validateIsProfileCantCreateWithoutMandatoryFields() {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='create-profile']//button[text()='Create profile']")));
	}

	public void validateIsMaximumNumberOfProfileIsReached() {
		String message = driver.findElement(By.xpath("//div[@class='create-profile']//span[@class='form__error']"))
				.getText();
		Assert.assertEquals(message, "Maximum number of profiles reached for this user.");

	}

}
