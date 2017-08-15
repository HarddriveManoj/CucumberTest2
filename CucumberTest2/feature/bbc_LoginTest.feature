Feature: BBC Login Action
	  I want to use this feature for verifying BBC Login functionality

  Scenario: User should be able to register with the BBC
    Given User is on BBC page
    When User clicks on Register link
    And User enters date of birth and clicks next
    And user enters email and password 
		And enters postcode 
		And selects gender 
		And unsubscribes for email updates 
		And clicks on register
    Then User should receive an confirmation email

  Scenario: Login should be successful with correct credentials
    Given User is on BBC page
    When User clicks on Sign in
    And User logs in using Username as "geno02@bbc.co.uk" and Password as "Test@123"
    Then Sign in should be successful

  Scenario: Login should not be successful with incorrect credentials
    Given User is on BBC page
    When User clicks on Sign in
    And User enters incorrect username as "geno02@bbc.co.uk" and password as "WRONG_PASSWORD"
    Then Sign in should not be successful
