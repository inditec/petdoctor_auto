@petdoctor @dev
Feature: Tests Petdoctor application

  @home_page @FR1
  Scenario: Verify header is displayed on petdoctor home page
    Given I am on petdoctor home page
    Then I should see petdoctor header

  @home_page @FR1
  Scenario: Verify links are displayed on petdoctor home page
    Given I am on petdoctor home page
    Then I should see links for 'Home', 'Find owners' and 'Veterinarians'

  @home_page @FR1
  Scenario: Verify Welcome text and image is displayed
    Given I am on petdoctor home page
    Then I should see Welcome text and home page image

  @find_owners_page @FR2 @pp
  Scenario: Verify Find owners page is displayed when Find owners link is clicked on home page
    Given I am on petdoctor home page
    When I click on Find owners link
    Then I should see Find owners page

  @find_owners_page @FR2 @pp
  Scenario Outline: Verify the validations for last name field on Find owners page
    Given I am on find owners page
    When I search for owners with text '<search_text>'
    Then I should see error message '<error_message>' next to last name
    Examples:
      | search_text                     | error_message                                   |
      | ab                              | Last Name must be between 3 and 30 chars        |
      | ab cdab cdab cdab cdab cdab cde | Last Name must be between 3 and 30 chars        |
      | -EMPTY-                         | Please enter Last name                          |
      | Krishna1                        | Last Name must contain only alphabets or spaces |
      | Krishna$                        | Last Name must contain only alphabets or spaces |
      | non existant user               | has not been found                              |

  @add_owner_page @FR3 @km
  Scenario: Verify add owner page is displayed when Add Owner link is clicked on Find Owners page
    Given I am on find owners page
    When I click on Add Owner link
    Then I should be on Add Owner page