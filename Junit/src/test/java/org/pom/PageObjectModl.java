package org.pom;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.ju.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModl extends BaseClass {

	public PageObjectModl() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	private WebElement Username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login")
	private WebElement login;


	public WebElement getUsername() {
		return Username;
	}
	
	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	
	
	
	
	

	}



