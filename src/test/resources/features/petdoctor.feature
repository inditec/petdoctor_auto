@petdoctor
Feature: Tests Petdoctor application

  @homepage
  Scenario: Verify header is displayed on petdoctor home page
    Given I am on petdoctor home page
    Then I should see petdoctor header

  @homepage
  Scenario: Verify links are displayed on petdoctor home page
    Given I am on petdoctor home page
    Then I should see links for 'Home', 'Find owners' and 'Veterinarians'

  @homepage
  Scenario: Verify Welcome text and image is displayed
    Given I am on petdoctor home page
    Then I should see Welcome text and home page image
