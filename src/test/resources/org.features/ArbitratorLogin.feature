Feature: Arbitrator login page

 @Sanity @ArbLogin @Arb
Scenario: Verify that Arbitrator is able to login or not
Given Arb user is on login page 
Then ArbUser name and ArbPassword field is displayed
When user see the user name field then enter ArbUser name 
Then user see the user password field then enter Arb password
When user see the pop up then he click on ok button 
And user verify the table title on the page as "Upcoming Oral Hearing"
And user click on Arb logout 
