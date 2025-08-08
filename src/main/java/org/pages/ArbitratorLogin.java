package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.ElementUtil;

public class ArbitratorLogin {
	private WebDriver  driver;
	public ArbitratorLogin(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css="input[id='email1']") 
	private WebElement UName;

	@FindBy(css="input[id='exampleInputPassword1']")
	private WebElement Pass;

	@FindBy(css="input[id='check_privacypolicy']")
	private WebElement InstructionCheckField;

	@FindBy(xpath="//button[@id='presolv_visit_cookieset']")
	private WebElement AcceptCookiesBtn;
	
	
	
	@FindBy(css="button[class='btn btn-warning btn-lg btnmobile mt-2 dwidth ulogin'][type='submit']")
	private WebElement SubmitBtn;

	@FindBy(xpath="//h4[normalize-space()='Upcoming Oral Hearing']")
	private WebElement TableTitle;

	@FindBy(css="a[href='https://staging.presolv360.com/logout']")
	private WebElement LogoutBtn;

	public void userPassDisplay() throws InterruptedException {
		Thread.sleep(2000);
		ElementUtil.eu.waitForVisibilityByWebElement(driver, 200, UName);
		if(UName.isDisplayed()&Pass.isDisplayed()) {
			System.out.println("UName & Pass are Display");
		}else {
			System.out.println("both field are not display");

		}
	}
	public void enterUName(String user) {
		UName.sendKeys(user);
	}
	public void enterPass(String pass) throws InterruptedException {
		Thread.sleep(2000);
		Pass.sendKeys(pass);
		InstructionCheckField.click();
		Thread.sleep(2000);
		if (AcceptCookiesBtn.isDisplayed()) {
			AcceptCookiesBtn.click();
			Thread.sleep(2000);
			  Actions actions = new Actions(driver);
		        actions.click().perform();

			
			SubmitBtn.click();
		} else {
			  Actions actions = new Actions(driver);
		        actions.click().perform();
			SubmitBtn.click();
		}
		
	}
	
	public void finalSubmitButton() {
		WebElement accept= driver.findElement(By.xpath("//button[@id='confirmLogin']"));
		ElementUtil.eu.waitForVisibilityByWebElement(driver, 20, accept);
		
		accept.click();
	}
	public void verifyTitle(String tname) {
		if (TableTitle.getText().equals(tname)) {
			System.out.println("User Successfully loged in");
		} else {
			System.out.println("fails to loged the application");
		}
	}
	public void login() throws InterruptedException {
		InstructionCheckField.click();
		Thread.sleep(2000);
		SubmitBtn.click();
	}
	public void arbLogout() {
		LogoutBtn.click();
	}
	
	
	
}
