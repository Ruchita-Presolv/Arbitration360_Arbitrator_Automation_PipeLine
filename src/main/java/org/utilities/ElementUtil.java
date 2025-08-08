package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	public static ElementUtil eu = new ElementUtil();
	public void waitForPageLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Contants.small_wait));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		});		
		/*Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });*/
	}
	public void waitForVisibilityByWebElement(WebDriver driver, int time, WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForElementToBeClickable(WebDriver driver,WebElement ele,int timeinSec) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(timeinSec));
		wt.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}
	public void waitForElementToBeClickableMinutes(WebDriver driver,WebElement ele,int timeinSec) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofMinutes(timeinSec));
		wt.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}
	public void scrollByPageDown(WebDriver driver,int num) {
		for(int i= 1;i<= num;i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		}
	}
	public void scrollByPageUp(WebDriver driver,int num) {
		for(int i= 1;i<= num;i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_UP);
		}
	}

	public void scrollByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	public void clickByJS(WebDriver driver,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	public void clickByOffset(WebDriver driver ,WebElement eleToClick) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(300, 400).click().build().perform();
		actions.moveToElement(eleToClick).click().build().perform();
	}
	
	public void clickByOffsetInt(WebDriver driver, int offsetX, int offsetY) {
	    Actions actions = new Actions(driver);
	    actions.moveByOffset(offsetX, offsetY).click().build().perform();
	}
	
	

	public void windowScrollUpByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, -window.innerHeight)");
	}
	public void windowScrollDownByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, window.innerHeight)");
	}

	public void pageRefresh(WebDriver driver, int num) {
		for(int i= 1;i<= num;i++) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.F5);
		}
	}
	public void pressEnter(WebDriver driver,int num) {
		for(int i=1;i<=num;i++){
			try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
	public void selectDropDownValue(WebDriver driver,WebElement Ele,String value) {
		WebElement dd1 = Ele;
		Select sel = new Select(dd1);
		sel.selectByVisibleText(value);
	}

	public void selectDropDownPosition(WebDriver driver,WebElement Ele,String position) {
		WebElement dd1 = Ele;
		Select sel = new Select(dd1);
		sel.selectByVisibleText(position);
	}
	public void selectDropDownTextPresent(WebDriver driver,WebElement Ele,String text) {
		WebElement dd1 = Ele;
		Select sel = new Select(dd1);
		sel.selectByVisibleText(text);

	}
	public void robotClassFileUpload(WebDriver driver, WebElement ele, String  relativep)
	{
		//UploadInterimZip.click(); //won't work
		ElementUtil.eu.clickByJS(driver, ele);
		Robot rb;
		try {
			rb = new Robot();
			rb.delay(2000);

			// put path to file in a clipboard
			// project doc path 
			String path= System.getProperty("user.dir");
			StringSelection ss = new StringSelection(path+relativep);
			//"\\documents\\Interimorder.zip"

			// local file path 
			//StringSelection ss = new StringSelection("C:\\Users\\HP01\\OneDrive\\Desktop\\Testing doc\\Interimorder\\Interimorder.zip"); // path of file 

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

			// CTRL+V
			rb.keyPress(KeyEvent.VK_CONTROL);  // press controll
			rb.keyPress(KeyEvent.VK_V);  // press v

			//release the key
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.delay(2000);

			// Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {

			e.printStackTrace();
		}

	}
	public void fluentWaitForvisibilityOfElement(String locater,int time,WebDriver driver,String locaterType) 
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofMinutes(time))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);
		switch(locaterType) {
		case "css" : fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locater)));
		break;
		case "xpath" : fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locater)));
		break;
		case "class" : fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locater)));
		break;
		case "id" : fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locater)));
		break;
		default: System.out.println("invalid locater type");
		break;

		}
	}
	public void switchToNewSingleWindow(WebDriver driver) 
	{
		String ParentWinId1 = driver.getWindowHandle();
		//System.out.println(ParentWinId1);

		Set<String> allWinId= driver.getWindowHandles();
		Iterator<String> itr = allWinId.iterator();
		String id1= itr.next();
		if(id1.equals(ParentWinId1)) {
			id1=itr.next();
		}
		driver.switchTo().window(id1);
		System.out.println(ParentWinId1);
		System.out.println(id1);
	}
	
	
}
