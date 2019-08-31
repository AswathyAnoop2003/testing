package mypackage;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;

public class excelregistration {

	private WebDriver driver;
	Sheet S;
	private StringBuffer verificationErrors = new StringBuffer();

	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver = new ChromeDriver();
		baseUrl = "http://automationpractice.com/index.php";

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test

	public void automationpracticetest() throws Exception {
		FileInputStream fi = new FileInputStream("C:\\Users\\rdx\\Desktop\\read2.xls");
		Workbook w = Workbook.getWorkbook(fi);
		S = w.getSheet(0);
		for (int row = 0; row <= S.getRows() - 1; row++) {
			String email = S.getCell(0, row).getContents();
			String fname = S.getCell(1, row).getContents();
			String lname = S.getCell(2, row).getContents();
			String password = S.getCell(3, row).getContents();
			String address = S.getCell(4, row).getContents();
			String city = S.getCell(5, row).getContents();
			String pincode = S.getCell(6, row).getContents();
			String phone = S.getCell(7, row).getContents();
			String refer = S.getCell(8, row).getContents();

			driver.get(baseUrl + "/");

			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.id("email_create")).click();
			driver.findElement(By.id("email_create")).clear();
			driver.findElement(By.id("email_create")).sendKeys(email);
			driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]"))
					.click();
			driver.findElement(By.id("id_gender2")).click();
			driver.findElement(By.id("customer_firstname")).click();
			driver.findElement(By.id("customer_firstname")).clear();
			driver.findElement(By.id("customer_firstname")).sendKeys(fname);
			driver.findElement(By.id("customer_lastname")).click();
			driver.findElement(By.id("customer_lastname")).clear();
			driver.findElement(By.id("customer_lastname")).sendKeys(lname);
			driver.findElement(By.id("email")).click();
			driver.findElement(By.id("passwd")).click();
			driver.findElement(By.id("passwd")).clear();
			driver.findElement(By.id("passwd")).sendKeys(password);
			driver.findElement(By.id("account-creation_form")).click();
			driver.findElement(By.id("firstname")).click();
			driver.findElement(By.id("lastname")).click();
			driver.findElement(By.id("address1")).click();
			driver.findElement(By.id("address1")).clear();
			driver.findElement(By.id("address1")).sendKeys(address);
			driver.findElement(By.id("city")).click();
			driver.findElement(By.id("city")).clear();
			driver.findElement(By.id("city")).sendKeys(city);
			driver.findElement(By.id("id_state")).click();
			new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Indiana");
			driver.findElement(By.id("id_state")).click();
			driver.findElement(By.id("postcode")).click();
			driver.findElement(By.id("postcode")).clear();
			driver.findElement(By.id("postcode")).sendKeys(pincode);
			driver.findElement(By.id("id_country")).click();
			driver.findElement(By.id("id_country")).click();
			driver.findElement(By.id("phone_mobile")).click();
			driver.findElement(By.id("phone_mobile")).clear();
			driver.findElement(By.id("phone_mobile")).sendKeys(phone);
			driver.findElement(By.id("alias")).click();
			driver.findElement(By.id("alias")).click();
			driver.findElement(By.id("alias")).clear();
			driver.findElement(By.id("alias")).sendKeys(refer);
			driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='DNI / NIF / NIE'])[1]/following::span[1]"))
					.click();
			driver.findElement(By.linkText("Sign out")).click();

			String hometitle = driver.getTitle();

			if (hometitle.contentEquals("Login - My Store")) {
				System.out.println("Successfully registered with the data in excel");
				// driver.findElement(By.linkText("Sign out")).click();

			} else {
				System.out.print(hometitle);
				System.out.println("Login failed");

			}
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
