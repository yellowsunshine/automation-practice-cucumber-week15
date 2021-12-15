Feature: Sign In Page Test
  User should be able to sign in successfully

  @Smoke @Regression
  Scenario: User should navigate to sign in page successfully
    Given user Clicks On The Sign In Link
    When user verifies that "AUTHENTICATION" authentication message is displayed

  @Sanity @Regression
  Scenario Outline: Verify the Error Message With Invalid Credentials
    Given user Clicks On The Sign In Link
    When user enters username "<username>" in the username field
    And user enters password "<password>" in the password field
    And clicks the sign in Button
    Then verifies the error message "<message>"
    Examples:
      | username       | password | message                    |
      |                | 123456   | An email address required. |
      | abcd@gmail.com |          | Password is required.      |
      | adfdfgfg       | 123456   | Invalid email address.     |
      | abcd@gmail.com | 123456   | Authentication failed.     |

  @Sanity @Regression
  Scenario: verify that user should log in successfully with valid credentials
    When user Clicks On The Sign In Link
    And user enters username "prime@gmail.com" in the username field
    And user enters password "Prime123" in the password field
#    And clicks the sign in Button
#    Then verifies that sign out link is displayed "Sign out"

  @Regression
  Scenario: verify that user should log out successfully
    When user Clicks On The Sign In Link
    And user enters username "prime@gmail.com" in the username field
    And user enters password "Prime123" in the password field
#    And clicks the sign in Button
#    And clicks on the sign out link
#    Then verifies that the sign in "Sign in" link is displayed