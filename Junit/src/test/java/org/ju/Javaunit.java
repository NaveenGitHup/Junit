package org.ju;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javaunit extends BaseClass {

	@BeforeClass
	public static void browersLaunch() {
		Javaunit.lunchBrowser("https://adactinhotelapp.com/");

	}

	@AfterClass
	public static void close() {
		// BaseClass.quit();

	}

	@Before
	public void check() throws IOException {
		TakesScreenshot shoot = (TakesScreenshot) driver;
		File s = shoot.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\Ashok 555\\Pictures\\Camera Roll\\akon.png");
		FileUtils.copyFile(s, file);

	}

	@After
	public void closes() throws IOException {
		TakesScreenshot shoot = (TakesScreenshot) driver;
		File s = shoot.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\Ashok 555\\Pictures\\Camera Roll\\akon1.png");
		FileUtils.copyFile(s, file);

	}

	@Test
	public void testing1() throws IOException {
		String excel = Javaunit.excel("Hello", 1, 0).toString();
		Javaunit.SendKeys("username", excel);
		String excel2 = Javaunit.excel("Hello", 1, 1).toString();
		SendKeys("password", excel2);
		Javaunit.click("id", "login");
		String excel3 = Javaunit.excel("Hello", 1, 2).toString();
		SendKeys("location", excel3);
		String excel4 = Javaunit.excel("Hello", 1, 3).toString();
		Javaunit.SendKeys("hotels", excel4);
		String excel5 = Javaunit.excel("Hello", 1, 4).toString();
		Javaunit.SendKeys("room_type", excel5);
		String excel6 = Javaunit.excel("Hello", 1, 5).toString();
		Javaunit.SendKeys("room_nos", excel6);
		Javaunit.clear("datepick_in");
		String excel7 = Javaunit.excel("Hello", 1, 6).toString();
		Javaunit.SendKeys("datepick_in", excel7);
		Javaunit.clear("datepick_out");
		String excel8 = Javaunit.excel("Hello", 1, 7).toString();
		Javaunit.SendKeys("datepick_out", excel8);
		String excel9 = Javaunit.excel("Hello", 1, 8).toString();
		Javaunit.SendKeys("adult_room", excel9);
		String excel0 = Javaunit.excel("Hello", 1, 9).toString();
		Javaunit.SendKeys("child_room", excel0);
		Javaunit.click("id", "Submit");

	}

	@Test
	public void Click() {
		Javaunit.click("id", "radiobutton_0");
		Javaunit.click("id", "continue");
	}

	@Test
	public void Filling() throws IOException, InterruptedException {
		String excel1 = Javaunit.excel("Hello", 1, 10).toString();
		Javaunit.SendKeys("first_name", excel1);
		String excel2 = Javaunit.excel("Hello", 1, 11).toString();
		Javaunit.SendKeys("last_name", excel2);
		String excel3 = Javaunit.excel("Hello", 1, 12).toString();
		Javaunit.SendKeys("address", excel3);
		String excel4 = Javaunit.excel("Hello", 1, 13).toString();
		Javaunit.SendKeys("cc_num", excel4);
		String excel5 = Javaunit.excel("Hello", 1, 14).toString();
		Javaunit.SendKeys("cc_type", excel5);
		String excel6 = Javaunit.excel("Hello", 1, 15).toString();
		Javaunit.SendKeys("cc_exp_month", excel6);
		String excel7 = Javaunit.excel("Hello", 1, 16).toString();
		Javaunit.SendKeys("cc_exp_year", excel7);
		String excel8 = Javaunit.excel("Hello", 1, 17).toString();
		Javaunit.SendKeys("cc_cvv", excel8);
		Javaunit.click("id", "book_now");
		Thread.sleep(5000);
		String att = Javaunit.getAtt("order_no", "value");
		Javaunit.setData("Hello", 1, 18, att);
		String att1 = Javaunit.getAtt("username_show", "value");
		Javaunit.setData("Hello", 1, 19, att1);

	}

	
		

	}

