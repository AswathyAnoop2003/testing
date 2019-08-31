package mypackage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		String parent = driver.getWindowHandle();
		System.out.print(driver.switchTo().window(parent).getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("button1")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// String child=driver.getWindowHandle();
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		Set children = driver.getWindowHandles();

		System.out.println(children);

		// Pass a window handle to the other window

		for (String children1 : driver.getWindowHandles()) {

			System.out.println(children1);

			driver.switchTo().window(children1);

		}

		// Closing Pop Up window

		driver.close();

		// Close Original window

		// driver.quit();

	}
}
