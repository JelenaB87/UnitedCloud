package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getDeleteProfileBtn() {
		return driver.findElement(By.xpath(
				"//div[@class='home']//div[@class='card']//div[@class='card__description']//button[text()='Delete profile']"));
	}

	public WebElement getNameProfile() {
		return driver.findElement(By.xpath(
				"//div[@class='home']//div[@class='card']//div[@class='card__description']/h2[@class='card__profile-name']"));
	}

	public WebElement getCreateProfileBtn() {
		return driver.findElement(By.xpath("//div[@class='main-wrapper']//button[text()='Create profile']"));
	}

	// Methods for delete

	public void deleteProfile() {
		this.getDeleteProfileBtn().click();
	}

	public boolean validateIsProfileSuccessfullDelete(String name) {
		boolean isDisplayed = false;

		try {
			driver.findElement(
					By.xpath("//div[@class='home']//div[@class='card']//div[@class='card__description']//h2[text()='"
							+ name + "']"));
		} catch (Exception e) {
			System.out.println("Profile doesnt exist");
			isDisplayed = true;
		}
		return isDisplayed;
	}

	public void createNewProfile() throws InterruptedException {
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[@class='main-wrapper']//button[text()='Create profile']")).click();
	}

}
