Feature: Puppy adoption Page Test

  @TestMain
  Scenario: Validate puppy adoption functionality
    Given The user is able to open the page "http://puppies.herokuapp.com/"
    When Select puppy 0 by clicking View Details button
    Then The user click on Adopt Me! button
    And User clicks on Complete the Adoption button
    Then The user fill adoption form
    And The user clicks Place Order button
    Then Validate the message of success is displayed

  @TestMain
  Scenario: Validate two puppy adoption functionality
    Given The user is able to open the page "http://puppies.herokuapp.com/"
    When Select puppy 0 by clicking View Details button
    Then The user click on Adopt Me! button
    And User clicks on add another puppy button
    Then Select puppy 1 by clicking View Details button
    And The user click on Adopt Me! button
    And User clicks on Complete the Adoption button
    Then The user fill adoption form
    And The user clicks Place Order button
    Then Validate the message of success is displayed


   @TestMain
     Scenario: Validate two puppy adoption functionality
       Given The user is able to open the page "http://puppies.herokuapp.com/"
       When Select puppy 0 by clicking View Details button
       Then The user click on Adopt Me! button
       And User clicks on add another puppy button
       Then Select puppy 1 by clicking View Details button
       And The user click on Adopt Me! button
       And User clicks on add another puppy button
       Then Select puppy 2 by clicking View Details button
       And The user click on Adopt Me! button
       Then Validate that all 3 puppies have been added to the cart
