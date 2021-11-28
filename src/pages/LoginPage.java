package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getUserName() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getLogin() {
		return driver.findElement(
				By.xpath("//div[@class='login pageLoaded']//div[@class='right-part']//button[text()='LOGIN']"));
	}

	// Method for login

	public void logIn(String username, String password) {
		this.getUserName().clear();
		this.getUserName().sendKeys(username);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getLogin().click();
	}
}
