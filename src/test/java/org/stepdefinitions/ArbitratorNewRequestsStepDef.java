package org.stepdefinitions;

import org.factory.DriverFactory;
import org.pages.ArbitratorNewRequestsPage;

import io.cucumber.java.en.*;

public class ArbitratorNewRequestsStepDef {
	ArbitratorNewRequestsPage Arb_NewR_obj = new ArbitratorNewRequestsPage(DriverFactory.getDriver());

	/***********************
	 * @UabilityOfActBtn
	 */

	@Given("user is on the dashboard page and click on the new request action")
	public void user_is_on_the_dashboard_page_and_click_on_the_new_request_action() {
		Arb_NewR_obj.newRequestAct();
	}
	@Then("user verify the page title as {string} and also check no of entries per page dropdown workability")
	public void user_verify_the_page_title_as_and_also_check_no_of_entries_per_page_dropdown_workability(String string) {
		Arb_NewR_obj.noOfCasesDropDown(string);
	}
	@Then("verify that button like Accept Reject and Comments are working or not")
	public void verify_that_button_like_accept_reject_and_comments_are_working_or_not() {
		Arb_NewR_obj.caseActionbtn();
	}
	@Then("user capture case id from platform and search for the same case id using search")
	public void user_capture_case_id_from_platform_and_search_for_the_same_case_id_using_search() {
		Arb_NewR_obj.caseIdSearch();
	}
	@Then("verify that proper search result displayed or not also verify the refresh btn")
	public void verify_that_proper_search_result_displayed_or_not_also_verify_the_refresh_btn() {
		Arb_NewR_obj.verifySearchCaseId();
	}
	@When("user click on case id then the case details page is displayed or not verify")
	public void user_click_on_case_id_then_the_case_details_page_is_displayed_or_not_verify() {
		Arb_NewR_obj.viewCaseDetails();
	}
	@Then("verify that the user able to select or unselect the case and also next page button working or not")
	public void verify_that_the_user_able_to_select_or_unselect_the_case_and_also_next_page_button_working_or_not() {
		Arb_NewR_obj.selectCaseAndNextBtn();
	}

	/***********************
	 * @throws InterruptedException 
	 * @DownloadRLNOAArbALetter
	 */
	@Then("user verify that able to download Request letter,NOA,Arbitration Appoint Letter")
	public void user_verify_that_able_to_download_request_letter_noa_arbitration_appoint_letter() throws InterruptedException {
		Arb_NewR_obj.downloadDoc();
	}
	@Then("user also verify that Back btn working or not")
	public void user_also_verify_that_back_btn_working_or_not() throws InterruptedException {
		Arb_NewR_obj.backBtn();
	}

	/*******************
	 * @Accept Case
	 * 
	 */
	@Then("user select first case on the page and click on the accept")
	public void user_select_first_case_on_the_page_and_click_on_the_accept() {
		Arb_NewR_obj.acceptClick();
	}
	@Then("user select all yes Radio btn for consent  and click on submit")
	public void user_select_all_yes_radio_btn_for_consent_and_click_on_submit() {
		Arb_NewR_obj.allYes();
	}

	@Then("user finally verify the success massage as {string} and click on the Ok btn")
	public void user_finally_verify_the_success_massage_as_and_click_on_the_ok_btn(String string) {
		Arb_NewR_obj.verifySuccessMass(string);
	}

	//=====Accept2====================

	@Then("user select all No Radio btn for consent  and click on submit")
	public void user_select_all_no_radio_btn_for_consent_and_click_on_submit() {
		Arb_NewR_obj.allNo();
	}
	//======Accept3===================

	@Then("user select all Yes,No,Yes Radio btn for consent  and click on submit")
	public void user_select_all_yes_no_yes_radio_btn_for_consent_and_click_on_submit() {
		Arb_NewR_obj.radioBtn();
	}

}
