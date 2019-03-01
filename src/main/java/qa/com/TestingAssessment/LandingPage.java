package qa.com.TestingAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	@FindBy(id = "j_username")
	private WebElement jUserBox;

	@FindBy(linkText = "New Item")
	private WebElement itemBox;

	@FindBy(id = "name")
	private WebElement docName;

	@FindBy(id = "j-add-item-type-standalone-projects")
	private WebElement docType;

	@FindBy(id = "ok-button")
	private WebElement createButton;

	@FindBy(id = "yui-gen38-button")
	private WebElement saveButton;

	@FindBy(partialLinkText = "Dashboard")
	private WebElement back2Dashboard;
	
	@FindBy(linkText = "Delete Project")
	private WebElement remove;
	
	@FindBy(linkText = "Manage Jenkins")
	private WebElement manageJ;
	
	
	@FindBy(partialLinkText = "Create/delete/")
	private WebElement newJ;
	
	@FindBy(linkText = "Create User")
	private WebElement createJ;
	
	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(name = "password1")
	private WebElement pass;

	@FindBy(name = "password2")
	private WebElement passCon;
	
//	@FindBy(id = "username")
//	private WebElement userName;
//
//	@FindBy(name = "password1")
//	private WebElement pass;
//
//	@FindBy(name = "password2")
//	private WebElement passCon;
	
	Actions action;

	public void login(WebDriver driver) {
		jUserBox.sendKeys("admin");
		action = new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys("admin").perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).click().perform();
		jUserBox.submit();
	}

	public void createProject(WebDriver driver, String projectName) throws InterruptedException {
		itemBox.click();

		docName.sendKeys(projectName);
		action.moveToElement(docType).moveByOffset(0, -50).click().perform();
		createButton.click();
		saveButton.click();
		back2Dashboard.click();
		Thread.sleep(3000);

	}

	public String checkProject(WebDriver driver, String projectName) {

		driver.findElement(By.linkText(projectName)).click();

		return driver.getCurrentUrl();

	}

	public void deleteProject(WebDriver driver, String projectName) {
		driver.findElement(By.linkText(projectName)).click();
		remove.click();
		action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RETURN).perform();
		
	}
	
	public void createUser(WebDriver driver) {
		manageJ.click();
		newJ.click();
		createJ.click();
		
	}

	// public void drawJ(WebDriver driver) {
	// Actions action = new Actions(driver);
	// action.moveToElement(canvas).moveByOffset(-150,
	// -150).clickAndHold().moveByOffset(0, 200).perform();
	// for (int i = 0; i < 7; i++) {
	// action.moveByOffset(-20, (int) -Math.pow(i, 2)).perform();
	// }
	// action.release().perform();
	// }

}
