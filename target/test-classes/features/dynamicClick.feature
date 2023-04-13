Feature: Luma searching and adding item to basket.

  Scenario:  As a user, I want to be able to search for items using SKU codes and add them to my basket on website.

    Given  the user is on the dashboard
    When the user searches for an item with the SKU code "24-WB07"
    And the user clicks  on the item "Overnight Duffle"
    When the user clicks on "Add to Cart" button
    And the user clicks on  "basket" button
    Then the user verifies that the "Overnight Duffle" item is present in the basket.
 #   And the user clicks on "luma" button
 #   And the user clicks on "women" button

  # Without dynamic click method!
  Scenario:  As a user, I want to be able to search for items using SKU codes and add them to my basket on website. (classic way same scenario with)

    Given  the user is on the dashboard
    When the user searches for an item with the SKU code "24-WB07"
    And the user clicks  on the item Overnight Duffle
    When the user clicks on Add to Cart button
    And the user clicks on basket button
    Then the user verifies that the "Overnight Duffle" item is present in the basket.




