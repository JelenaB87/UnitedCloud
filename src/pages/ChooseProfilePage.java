package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseProfilePage extends BasicPage {

	public ChooseProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getFamilyProfile() {
		return driver.findElement(By.xpath("//div[@class='choose']//div[@class='profiles']/div[@class='profiles__profile']//span[text()='Family']"));
	}
	public WebElement getCreateNewProfile() {
		return driver.findElement(By.xpath("//div[@class='choose']/div[contains(@class, 'create')]/button[text()='Create new profile']"));
	}
	
	
	// Method for choose
	
	public void chooseFamily() {
		this.getFamilyProfile().click();
	}
	
	public void chooseProfile(String name) {
		driver.findElement(By.xpath("//div[@class='choose']//div[@class='profiles']//div[@class='profiles__profile']//span[text()='"+ name +"']/ancestor::div[@class='profiles__profile']")).click();
	}
	
	public void createNewProfile() {
		this.getCreateNewProfile().click();
	}
	
}
