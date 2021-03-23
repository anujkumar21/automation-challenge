Feature: As a User I want to Log into Contorion website so that I can search for a Hammer

  Scenario: Verify user should be able to login into Cotorion website with valid credentials from Anmelden option present on header and can search for hammer.
    Given User is on home page
    When User opens login menu options
    And Enters email "<email-address>"
    And Enters password "<password>"
    And Clicks on login button
    Then Verify user should be logged in
    And User searches for "hammer"
    Then Verify product filter page should have products filtered by "hammer"