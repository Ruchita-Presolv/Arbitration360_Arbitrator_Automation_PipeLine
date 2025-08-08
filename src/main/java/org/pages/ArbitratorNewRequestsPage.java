package org.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.ElementUtil;

public class ArbitratorNewRequestsPage {
	private WebDriver driver;
	public ArbitratorNewRequestsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	/***********************
	 * @UabilityOfActBtn
	 */

	@FindBy(xpath="//span[normalize-space()='New Request']")
	private WebElement NewRequestBtn;

	@FindBy(css="select[class='form-control form-control-sm']")
	private WebElement NoOfCasesDropSelect;

	@FindBy(css="input[class='form-control form-control-sm']")
	private WebElement SearchField;

	@FindBy(css="button[id='search_btn']")
	private WebElement SearchBtn;

	@FindBy(css="button[id='clear_btn']")
	private WebElement SearchRefreshBtn;

	@FindBy(css="input[class='blkchk check_mark d-block']")
	private WebElement CheckField;

	@FindBy(css="a[href ^='/arbitrator/disclosure?id=']")
	private WebElement AcceptBtn;

	@FindBy(css="button[class='btn btn-inline btn-danger label label-success']")
	private WebElement RejectBtn;

	@FindBy(css=" button[id='dropdownMenuButton']")
	private WebElement CommentsBtn;

	@FindBy(css="a[href^='/arbitrator/arbitration/brief?id=']")
	private WebElement AnyCaseId;

	@FindBy(xpath="//a[@class='page-link'][text()='Previous']")
	private WebElement PreviousBtn;

	@FindBy(xpath="//a[@class='page-link'][text()='Next']")
	private WebElement NextBtn;

	@FindBy(css="span[class='nav-link-in']")
	private WebElement PageTitle;

	@FindBy(xpath="//h3[contains(normalize-space(),'Case ID: A0')]")
	private WebElement CaseDetailsPage;

	public void newRequestAct() {
		NewRequestBtn.click();
	}
	public void noOfCasesDropDown(String pName) {
		if (PageTitle.getText().contains(pName)) {
			System.out.println("title is matched");
			if (NoOfCasesDropSelect.isEnabled()) {
				System.out.println("no of entries per page is working");
			} else {
				System.out.println("no of entries per page is NOT working");
			} 
		} else {
			System.out.println("title Not matched");
		}
	}
	public void caseActionbtn() {
		if (AcceptBtn.isEnabled()&RejectBtn.isEnabled()&CommentsBtn.isEnabled()) {
			System.out.println("All Action Btn are working");
		} else {
			System.out.println("All are not working");

		}
	}
	public void caseIdSearch() {
		//AnyCaseId.getText()
		SearchField.sendKeys(AnyCaseId.getText());
		//ElementUtil.eu.clickByJS(driver, SearchBtn);
		//SearchBtn.click();
	}
	public void verifySearchCaseId() {
		if (AnyCaseId.isDisplayed()) {
			System.out.println("Successfully loaded the searched case id");
			//SearchRefreshBtn.click();
		} else {
			System.out.println("Fails to load the case searched");
		}
	}
	public void viewCaseDetails() {
		ElementUtil.eu.clickByJS(driver, AnyCaseId);
		//AnyCaseId.click();
		ElementUtil.eu.switchToNewSingleWindow(driver);
		if (CaseDetailsPage.isDisplayed()) {
			System.out.println("case details  page loaded successfully");
			ElementUtil.eu.switchToNewSingleWindow(driver);
		} else {
			System.out.println("fails to load case details page");
		}

	}
	public void selectCaseAndNextBtn() {
		if (CheckField.isEnabled()&PreviousBtn.isEnabled()&NextBtn.isEnabled()) {
			System.out.println("all are working next/previous");

		} else {
			System.out.println("all are Not working next/previous");
		}
	}

	/***********************
	 * @DownloadRLNOAArbALetter
	 */

	@FindBy(xpath="//td[text()='Request Letter:']/../td[2]//a[@href='javascript:void()']")
	private WebElement RequestLetterDownload;

	@FindBy(xpath="//td[text()='Registration of Arbitration:']/../td[2]//a[@href='javascript:void()']")
	private WebElement NOADownload;

	@FindBy(xpath="//td[text()='Arbitrator Appointment Letter:']/../td[2]//a[@href='javascript:void()']")
	private WebElement ArbitratorAppointmentLetterDownload;

	@FindBy(css="a[class='btn ybigbtn']")
	private WebElement BackBtn;

	public void downloadDoc() throws InterruptedException {

		AnyCaseId.click();
		ElementUtil.eu.switchToNewSingleWindow(driver);
		ElementUtil.eu.scrollByJS(driver, RequestLetterDownload);
		Thread.sleep(2000);
		if (RequestLetterDownload.isEnabled()&NOADownload.isEnabled()
				&ArbitratorAppointmentLetterDownload.isEnabled()) {
			//NOADownload.click();
			System.out.println("Successfully  download Documents");
		} else {
			System.out.println("Fails to download Documents");
		}
	}

	public void backBtn() throws InterruptedException {
		if (BackBtn.isEnabled()) {
			System.out.println("Back btn working");
			Thread.sleep(2000);
		} else {
			System.out.println("Back Not btn working");
		}
	}


	/*******************
	 * @Accept Case
	 * 
	 */
	@FindBy(css="a[class='btn btn-primary']")
	private WebElement AcceptCaseBtn;

	@FindBy(xpath="//div[@class='card-block']//div[3]//div[2]//label//input[@value='1']")
	private WebElement FirstYes;

	@FindBy(xpath="//div[@class='card-block']//div[3]//div[2]//label//input[@value='2']")
	private WebElement FirstNo;


	@FindBy(xpath="//div[@class='card-block']//div[4]//div[2]//label//input[@value='1']")
	private WebElement SecondYes;

	@FindBy(xpath="//div[@class='card-block']//div[4]//div[2]//label//input[@value='2']")
	private WebElement SecondNo;

	@FindBy(xpath="//div[@class='card-block']//div[5]//div[2]//label//input[@value='1']")
	private WebElement ThirdYes;

	@FindBy(xpath="//div[@class='card-block']//div[5]//div[2]//label//input[@value='2']")
	private WebElement ThirdNo;

	@FindBy(xpath="//button[@id='disclosure_form']")
	private WebElement  SubmitBtn ;

	@FindBy(xpath="//h2[@class='swal2-title']")
	private WebElement SuccessMass; 

	@FindBy(xpath="//button[@class='swal2-confirm swal2-styled']")
	private WebElement OkBtn ;

	public void acceptClick() {
		System.out.println(AnyCaseId.getText());
		AcceptCaseBtn.click();
	}
	public void allYes() {
		yesNoRadio(FirstYes, SecondYes, ThirdYes);	
		/*
		 * FirstYes.click(); SecondYes.click(); ThirdYes.click();
		 * ElementUtil.eu.clickByJS(driver, SubmitBtn);
		 * 
		 */
	}
	public void allNo() {
		yesNoRadio(FirstNo, SecondNo, ThirdNo);
		/*
		 * FirstNo.click(); SecondNo.click(); ThirdNo.click();
		 * ElementUtil.eu.clickByJS(driver, SubmitBtn);
		 */
	}
	public void radioBtn() {
		yesNoRadio(FirstYes, SecondNo, ThirdYes);	
	}
	public void yesNoRadio(WebElement radio1,WebElement radio2, WebElement radio3) {
		radio1.click();
		radio2.click();
		radio3.click();
		ElementUtil.eu.clickByJS(driver, SubmitBtn);
	}
	public void verifySuccessMass(String mass) {
		if (SuccessMass.getText().contains(mass)) {
			System.out.println("Sucessfully Accepted the case");
			OkBtn.click();

		} else {
			System.out.println("Fails to accept the case");
		}
	}



}
