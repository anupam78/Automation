@Search
Feature: Search Profile
  As a user of the google
  I want to search query string

  Background: User navigates to google search page

  Scenario: Search Scenario
    Given I am on the page on URL "https://www.google.com/"
    Then I should see page title as "Google"
    When I fill query string in search box "q" with "Cars"
    Then Verify suggestion is displayed
    And I click on the "btnG" button
    Then Verify Dictionary is shown with "Cars" as result