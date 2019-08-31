package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class crossbrowser {

	public WebDriver driver;

	@BeforeTest
	public void print() {
		System.out.println("starting browsers");

	}

	@AfterTest

	public void close() {
		System.out.println("closing browsers");
		// driver.close();

	}

	@Test
	public void launchchrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");

	}

	@Test
	public void launhmozilla() {
		System.setProperty("mozilla", "c:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.phptravels.net/");

	}

	@Test
	public void launhedge() {
		System.setProperty("edge", "c:\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.phptravels.net/");

	}

}
