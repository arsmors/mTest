Feature: B description

  Scenario Outline: B scenario
    Given website with category "<category>"
    When user adds <items> items to shopping basket
    And proceeds with checkout
    Then the sign in page is loaded
    When user signs in with credentials emails <email> password <password>
    Then user is redirected to checkout page
    And the shopping bag should contain total <items> items
    When user confirms delivery address
    Then user is redirected to delivery options page
    When user selects <delivery> delivery
    And user selects <payment> payment type
    Then use this card button becomes active

    Examples:
      | category | items | email  | password  | delivery | payment |
      | WOMEN    | 2     | email1 | password1 | omniva   | paypal  |