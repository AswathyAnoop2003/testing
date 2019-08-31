package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class title {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String expected = "facebook";
		String actual = driver.getTitle();

		if (actual.contentEquals(expected))

			System.out.println("well done");
		else
			System.out.println(actual);
		System.out.println("failed");
		driver.findElement(By.name("email")).sendKeys("aswathy");
		// WebElement radio1 = driver.findElement(By.xpath("//*[@id=\"u_0_5\"]"));
		WebElement radio1 = driver.findElement(By.className("_8esa"));
		radio1.click();
		driver.findElement(By.linkText("Forgotten account?")).click();
		driver.navigate().back();
		Select drop = new Select(driver.findElement(By.id("day")));
		drop.selectByVisibleText("25");
		Select drop2 = new Select(driver.findElement(By.id("month")));
		drop2.selectByIndex(12);

	}

}
