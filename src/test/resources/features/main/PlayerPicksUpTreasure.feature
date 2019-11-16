@Adhoc
Feature: When the player moves to the treasure, the player now has the treasure.

  Background: 
    Given the level design is:
      | XXXXX |
      | X  TX |
      | X P X |
      | X   X |
      | XXXXX |

  Scenario: Move right into empty space
    When the player moves right
    Then the player is located at (4, 3)
    Then the treasure is located at (3, 2)
    Then the player owns 0 treasure

  Scenario: Move up into empty space
    When the player moves up
    Then the treasure is located at (4, 3)
    Then the player is located at (3, 2)
    Then the player owns 0 treasure

  Scenario: Moves up and right into treasure space
    When the player moves up
    When the player moves right
    Then the treasure is not located at (4, 3)
    Then the player is located at (4, 3)
    Then the player owns 1 treasure
    
    
