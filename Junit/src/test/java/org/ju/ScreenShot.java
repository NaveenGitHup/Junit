package org.ju;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot extends BaseClass {
	

	@BeforeClass
	public static void lunch() {
		BaseClass.lunchBrowser("https://www.facebook.com/");
	}

	@AfterClass
	public static void quit() {

	}

	@Before
	public void ScreenShots() throws IOException {
		TakesScreenshot shot = ((TakesScreenshot) driver);
		File as = shot.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\Ashok 555\\Pictures\\Camera Roll\\akon.png");
		FileUtils.copyFile(as, file);

	}
	@After
	public void screenshot () throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File as = shot.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\Ashok 555\\Pictures\\Camera Roll\\akon2.png");
		FileUtils.copyFile(as, file);
		
	}

	@Test
	public void testing1() throws InterruptedException {
		BaseClass.SendKeys("email", "Akon naveen");
		Thread.sleep(3000);
		String att = BaseClass.getAtt("email", "value");
		Assert.assertEquals("username", "Akon naveen",att);
		BaseClass.SendKeys("pass", "Rdx@555");		
		BaseClass.click("name", "login");
		String gettitel = BaseClass.Gettitel();
		boolean contains = gettitel.contains("log in");
		Assert.assertTrue("verify title contains ",contains);
	}

}
