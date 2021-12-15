Feature: Create Account Page Test
  I want to check the create account page functionality

  @Smoke @Sanity @Regression
  Scenario: I want to verify that user should create account successfully
    Given user Clicks On The Sign In Link
    When I enter username in the email address field
    And I click on the 'Create an account' button
    And I fill all mandatory fields
      | Mrs. | Lisa | Smith | Lisa123456 | 123 Abc Avenue |
    And I enter all address detail fields
      | Lisa | Smith | 123 Abc Avenue | London | California | 12345 | 07912345678 |
    And I click on the 'Register' button
    Then I verify the 'My account' message "MY ACCOUNT"