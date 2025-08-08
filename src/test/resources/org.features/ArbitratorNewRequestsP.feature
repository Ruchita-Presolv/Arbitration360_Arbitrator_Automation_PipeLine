Feature: Verify that all Action present on New Request page are working as required

  Background: 
    Given Arb user is on login page
    Then ArbUser name and ArbPassword field is displayed
    When user see the user name field then enter ArbUser name
    Then user see the user password field then enter Arb password
    When user see the pop up then he click on ok button 

  @Smoke @UabilityOfActBtn @Arb
  Scenario: verify that all action present on the page are working or not
    Given user is on the dashboard page and click on the new request action
    Then user verify the page title as "New Request" and also check no of entries per page dropdown workability
    And verify that button like Accept Reject and Comments are working or not
    Then user capture case id from platform and search for the same case id using search
    And verify that proper search result displayed or not also verify the refresh btn
    When user click on case id then the case details page is displayed or not verify
    Then verify that the user able to select or unselect the case and also next page button working or not

  @Sanity @DownloadRLNOAArbALetter @Arb
  Scenario: verify that user able to click  the case details and download various document related to the case id
    Given user is on the dashboard page and click on the new request action
    Then user capture case id from platform and search for the same case id using search
    But user verify that able to download Request letter,NOA,Arbitration Appoint Letter
    And user also verify that Back btn working or not

  @Sanity @Accept1 @Arb
  Scenario: User select any case from platform and verify Accept action
    Given user is on the dashboard page and click on the new request action
    Then user select first case on the page and click on the accept
    And user select all yes Radio btn for consent  and click on submit
    And user finally verify the success massage as "Consent and disclosures submitted." and click on the Ok btn

