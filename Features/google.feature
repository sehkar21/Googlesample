@smoke
Feature: Google Search

  Scenario: Searching with Selenium
    Given I am on the Google homepage
    When I search for "Selenium BDD"
    Then I should see results related to "Selenium BDD"