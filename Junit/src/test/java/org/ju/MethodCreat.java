package org.ju;

import java.awt.Window;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.internal.SuppressJava6Requirement;

public class MethodCreat {
	static Select sel;
	static WebDriver driver;
	static String windowHandle;
	static JavascriptExecutor js;

	// **DROPDOWN*/
	public static void lunchBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void finfElement(String element) {
		driver.findElement(By.id(element));
		driver.findElement(By.name(element));
		driver.findElement(By.xpath(element));

	}

	public static void sendKey(String elemntType, String elemnt, String keysToSend) {
		if (elemntType == "id")
			driver.findElement(By.id(elemnt)).sendKeys(keysToSend);
		if (elemntType == "xpath")
			driver.findElement(By.xpath(elemnt)).sendKeys(keysToSend);
	}

	public static void click(String elemnt) {

		WebElement findElement = driver.findElement(By.name(elemnt));
		findElement.click();

	}

	/** GET TITLE */
	public static String getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;

	}

	public String getText(WebElement element, String id) {

		WebElement findElement = driver.findElement(By.id(id));
		String text = findElement.getText();
		System.out.println(text);
		return text;

	}

	public static String getTextxpath(String value) {
		WebElement findElement = driver.findElement(By.xpath(value));
		String text = findElement.getText();
		System.out.println(text);
		return text;

	}

	public static void SelectBY(String element, String type, String input) {
		sel = new Select(driver.findElement(By.id(element)));
		if (type == "index") {
			int rx = Integer.parseInt(input);
			sel.selectByIndex(rx);
		}
		if (type == "value")
			sel.selectByValue(input);
		if (type == "text")
			sel.selectByVisibleText(input);
	}

	public List<WebElement> getOp() {
		List<WebElement> options = sel.getOptions();
		return options;
	}

	public List<WebElement> getAllSelectOP() {
		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public WebElement getfirstselOP() {
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public boolean isMultiple() {
		boolean multiple = sel.isMultiple();
		return multiple;
	}

	public static void deSelectBy(String eletype, String element, String type, String input) {
		if (element == "id")
			sel = new Select(driver.findElement(By.id(element)));
		if (element == "xpath")
			sel = new Select(driver.findElement(By.xpath(element)));
		if (type == "index")
			sel.deselectByIndex(1);
		if (type == "value")
			sel.deselectByValue(input);
		if (type == "text")
			sel.deselectByVisibleText(input);
		if (type == "deselectAll")
			sel.deselectAll();
	}

	/** FRAMES */

	public static void switchFrame(String inputtype, String input) {
		if (inputtype == "index") {
			int frame = Integer.parseInt(input);
			driver.switchTo().frame(frame);
		}
		if (inputtype.contains("locator")) {
			WebElement frame = null;
			if (inputtype.contains("id")) {
				frame = driver.findElement(By.id(input));
			}
			if (inputtype.contains("xpath"))
				frame = driver.findElement(By.xpath(input));
			driver.switchTo().frame(frame);
		}
	}

	/** EXITE FORM FRAME */
	public void defalutContent() {
		driver.switchTo().defaultContent();
	}

	/** PERVIOUS-FRAME/PARENT-FRAME */

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	/** WINDOW HANDLING */

	public static void windowHandling() {
		windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if (string != "windowHandles") {
				driver.switchTo().window(string);
			}
		}
	}

	/** PARENT WINDOW */
	public static void parentWindow() {
		driver.switchTo().window(windowHandle);

	}

	/** JAVA SCRIPT */
	public static void javaScript(String value, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement findElement = driver.findElement(By.xpath(value));
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", findElement);
	}

	public static String getAttributvalue(String string, String value) {
		WebElement findElement = driver.findElement(By.xpath(value));
		String attribute = findElement.getAttribute(value);
		System.out.println(attribute);
		return attribute;
	}

	/** scrollIntoView */
	public static void scrollIntoView(String type, String id) {
		if (type == "id") {
			WebElement findElement = driver.findElement(By.id(id));
			js.executeScript("arguments[0].scrollIntoView(true)", findElement);
		}
		if (type == "xpath") {
			// WebElement findElement2 = driver.findElement(By.xpath(id));
			js.executeScript("arguments[0].scrollIntoView(true)");
		}

	}

}
