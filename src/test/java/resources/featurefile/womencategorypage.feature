Feature: Women Category Page Test
  Checking the women category page functionality

  @Smoke @Regression
  Scenario: Verify user should add product to the cart successfully
    Given I click on 'WOMEN' tab
    Then I verify "Women" women page text

  @Sanity @Regression
  Scenario Outline: Verify user should add product to cart successfully
    Given I click on 'WOMEN' tab
    When I click on the product "<product>"
    And Change quantity "<quantity>"
    And select the size "<size>"
    And select the colour "<colour>"
    And click on the 'Add to Cart' button
    And verify the popup message ""
    Then Click on the 'X' button and close the popup
    Examples:
      | product               | quantity | size | colour |
      | Blouse                | 2        | M    | White  |
      | Printed Dress         | 3        | L    | Orange |
      | Printed Chiffon Dress | 4        | S    | Green  |
      | Printed Summer Dress  | 2        | M    | Blue   |


