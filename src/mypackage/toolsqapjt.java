
package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class toolsqapjt {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/");
		String parentHandle = driver.getWindowHandle();

		// 1>compare title
		System.out.println("Comparing page title here");
		String actualTitle = driver.getTitle();
		System.out.println("The title of the page is  " + actualTitle);
		String expectedTitle = "QA Automation Tools Tutorial";
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");

		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

//2>clicking on Demo sites 

		driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[7]/a/span/span")).click();

//3>Finding Automation practice Form and set some delay to click

		WebElement first = driver.findElement(
				By.xpath("//span[contains(@class,'menu-text')][contains(text(),'Automation Practice Form')]"));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		first.click();
		// 4>fill in the forms
		driver.findElement(By.name("firstname")).sendKeys("Aswathy");// text
		driver.findElement(By.name("lastname")).sendKeys("Anoop");// text
		WebElement radio1 = driver.findElement(By.id("sex-1"));// radio
		WebElement radio2 = driver.findElement(By.id("exp-0"));// radio
		radio1.click();
		radio2.click();
		driver.findElement(By.id("datepicker")).sendKeys("9/2/19");// date
		WebElement checkbox1 = driver.findElement(By.id("profession-1"));// checkbox
		checkbox1.click();
		WebElement b = driver.findElement(By.id("photo"));
		b.sendKeys("c:/Users/rdx/Desktop/rose.jpg");// fileupload
		System.out.println("The file is uploaded");
		// driver.findElement(By.linkText("Test File to Download")).click();//file
		// download
		System.out.println("The file is downloaded");
		WebElement checkbox2 = driver.findElement(By.id("tool-2"));
		checkbox2.click();// checkbox
		Select continents = new Select(driver.findElement(By.name("continents")));// dropdown
		continents.selectByVisibleText("Europe");
		Select commands = new Select(driver.findElement(By.name("selenium_commands")));// From optionbox select one
																						// option
		commands.selectByVisibleText("Wait Commands");
		driver.findElement(By.name("submit")).click();// click submit button
		System.out.println("The form is filledup and Login is successfull");

		// 5>>Automation practice switch windows
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[7]/a/span/span")).click();// pointing to DemoSite
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		// Finding Automation practice switch windows
		WebElement second = driver.findElement(By
				.xpath("//span[contains(@class,'menu-text')][contains(text(),'Automation Practice Switch Windows')]"));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);// give waiting time to find element
		second.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);// give some resting time

		driver.findElement(By.id("alert")).click();// click on alertbox
		Alert alert = driver.switchTo().alert(); // switch to Alertbox
		String alertMessage = driver.switchTo().alert().getText();// Capturing alert message.
		System.out.println("The message in the alertbox is displayed below");
		System.out.println(alertMessage); // Displaying alert message
		alert.accept(); // Accepting alert
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.findElement(By.id("button1")).click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);// child window

		}

		driver.close();
		driver.switchTo().window(parentHandle);
		System.out.println("the window is handled and returned to parent window");
// 6>>AUTOMATION PRACTICE TABLE
		// goto primrymenu and finding the Automation Practice Table and click
		driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[7]/a/span/span")).click();
		WebElement third = driver.findElement(
				By.xpath("//span[contains(@class,'menu-text')][contains(text(),'Automation Practice Table')]"));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		third.click();
		// finding rows of the table using xpath-pointing structure
		System.out.println("Reading data from the table");
		java.util.List<WebElement> row = driver.findElements(By.xpath(".//*[@id='content']/table/tbody/tr"));
		int rowcount = row.size();
		System.out.println("No.of Rows in the Table : " + rowcount);

		// printing the datas in the diagonal cells
		System.out.println("The diagonal elemnts are ");
		for (int i = 1; i <= 4; i++) {
			String diagdata = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[" + i + "]")).getText();
			System.out.println(diagdata);
		}

	}
}
