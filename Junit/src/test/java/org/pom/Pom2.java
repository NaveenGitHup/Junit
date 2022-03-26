package org.pom;

import org.ju.BaseClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class Pom2 extends PageObjectModl {
public Pom2(WebDriver driver) {
	
	//this.WebDriver=driver;
	//PageFactory.initElements(driver), this);
}
	
	@BeforeClass
	public static void launch(WebDriver driver) {
		BaseClass.lunchBrowser("\"https://adactinhotelapp.com/\"");
		

	}
	
	
	
}
