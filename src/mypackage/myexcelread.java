package mypackage;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class myexcelread {

	public static void main(String[] args) throws BiffException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		File src = new File("C:\\Users\\rdx\\Desktop\\read1.xls");
		Workbook wb = Workbook.getWorkbook(src);
		Sheet s = wb.getSheet(0);
		Cell c = s.getCell(0, 0);
		int count = s.getRows();
		for (int i = 0; i <= count + 1; i++) {
			String s1 = s.getCell(0, i).getContents();
			String s2 = s.getCell(1, i).getContents();
			driver.findElement(By.name("email")).sendKeys(s1);
			driver.findElement(By.id("pass")).sendKeys(s2);
		}

	}
}
