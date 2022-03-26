package org.ju;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends MethodCreat {
	public static WebDriver driver;

	public static void driver(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	public static Cell excel(String name, int rownum, int cellnum) throws IOException {

		File file = new File("F:\\akonNaveen\\naveen\\Junit\\excel\\Ada hotal junit.xlsx");
		FileInputStream strem = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(strem);
		Sheet sheet = book.getSheet(name);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		System.out.println(cell);
		return cell;

	}

	public static void SendKeys(String webElement, String excel) {
		driver.findElement(By.id(webElement)).sendKeys(excel);
	}

	public static void click(String type, String name) {
		if (type == "id") {
			WebElement findElement = driver.findElement(By.id(name));
			findElement.click();
		}
		if (type == "name") {
			WebElement findElement = driver.findElement(By.name(name));
			findElement.click();
		}

	}

	public void Selectby(String type, String id, String value) {
		if (type == "id") {
			WebElement findElement = driver.findElement(By.id(id));
			Select sel = new Select(findElement);
			sel.selectByValue(value);
		}
		if (type == "xpath") {
			WebElement findElement = driver.findElement(By.xpath(id));
			Select sel = new Select(findElement);
			sel.selectByVisibleText(value);
		}

	}

	public static String getAtt(String id, String name) {
		WebElement findElement = driver.findElement(By.id(id));
		String value = findElement.getAttribute(name);
		return value;

	}

	public static void setData(String name, int rownum, int column, String att) throws IOException {
		File file = new File("F:\\akonNaveen\\naveen\\Junit\\excel\\Ada hotal junit.xlsx");
		FileInputStream strem = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(strem);
		Sheet sheet = book.getSheet(name);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(column);
		cell.setCellValue(att);
		FileOutputStream out = new FileOutputStream(file);
		book.write(out);

	}

	public static void screenShot() throws IOException {
		TakesScreenshot shoot = (TakesScreenshot) driver;
		File s = shoot.getScreenshotAs(OutputType.FILE);
		File file = new File("Pictures//akon.png");
		FileUtils.copyFile(s, file);

	}

	public static void quit() {
		driver.quit();

	}

	/** GET TITEL */
	public static String Gettitel() {
		String title = driver.getTitle();
		return title;

	}

	/** GetText */
	public static String getTxt(String id) {

		WebElement findElement = driver.findElement(By.id(id));
		String text = findElement.getText();
		return text;

	}
/**CLEAR*/
	public static void clear(String id) {
		driver.findElement(By.id(id)).clear();
		
}
	
	/**BY CREATING WEBELEMENT*/
	public void Sendky() {

	}
	
	
}
