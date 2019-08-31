package mypackage;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.By;

public class phptravels {
	@Test
	public void executSessionOne() {
		// First session of WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.phptravels.net/login");
		// find user name text box and fill it
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		System.out.println("Login sucessfully in session1");
		driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/button")).click();

	}

	@Test
	public void executeSessionTwo() {
		// Second session of WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.phptravels.net/admin");
		driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demoadmin");
		driver.findElement(By.xpath("/html/body/div/form[1]/button")).click();
		System.out.println("Login sucessfully in session2");
	}

	@Test
	public void executSessionThree() {
		// Third session of WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.phptravels.net/supplier");
		// find user name text box and fill it
		driver.findElement(By.name("email")).sendKeys("supplier@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demosupplier");
		driver.findElement(By.xpath("/html/body/div/form[1]/button")).click();
		System.out.println("Login sucessfully in session3");
	}
}
