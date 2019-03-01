package qa.com.TestingAssessment;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class ProjectCreationTest {
	
	WebDriver driver;
	String projectName;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER);
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.addArguments("--headless");		
		driver = new ChromeDriver(chromeOptions);
		
//		System.setProperty("webdriver.chrome.driver", Constants.DRIVER);
//		driver = new ChromeDriver();

	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	

	@Test
	public void test1() throws InterruptedException {
		driver.get(Constants.HOMEPAGE);

		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);

		landingPage.login(driver);
		projectName = "CHANGEME";
		landingPage.createProject(driver, projectName);

		
		assertEquals(landingPage.checkProject(driver, projectName), "http://35.234.154.113:8080/job/" + projectName + "/");
//		Boolean myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.urlMatches("http://35.234.154.113:8080/job/" + projectName + "/")); 
//		landingPage.deleteProject(driver, projectName);
	}
}
