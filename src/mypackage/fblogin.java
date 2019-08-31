package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fblogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\www.facebook.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		WebElement element1 = driver.findElement(By.id("email"));
		element1.sendKeys("abc");
		WebElement element2 = driver.findElement(By.id("pass"));
		element2.sendKeys("abc");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		WebElement element3 = driver.findElement(By.id("loginbutton"));
		element3.click();

		// driver.close();
		// System.exit(0);

	}

}
