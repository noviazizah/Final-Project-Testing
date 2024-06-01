Feature: User API Controller - Update User Data

  Background:
    Given access to the User API is confirmed

  Scenario: Successfully update user's title
    Given the app-id "66271b536cae0377a3dee7c6" is authorized in the header
    And the user ID "60d0fe4f5311236168a109ca" is valid
    When I send a PUT request to modify the user's title to "miss"
    Then the response should have a status code of 200
    And the title in the response should reflect the update to "miss"

    Scenario: Successfully update user's firstName
    Given the app-id "66271b536cae0377a3dee7c6" is authorized in the header
    And the user ID "60d0fe4f5311236168a109ca" is valid
    When I send a PUT request to modify the user's firstName to "Suzy"
    Then the response should have a status code of 200
    And the response should confirm the firstName has been updated to "Suzy"

    Scenario: Successfully update user's lastName
    Given the app-id "66271b536cae0377a3dee7c6" is authorized in the header
    And the user ID "60d0fe4f5311236168a109ca" valid
    When I send a PUT request to modify the user's lastName to "Bae"
    Then the response should have a status code of 200
    And the response should confirm the lastName has been updated to "Bae"

    Scenario: Successfully update user's gender
    Given the app-id "66271b536cae0377a3dee7c6" is authorized in the header
    And the user ID "60d0fe4f5311236168a109ca" is valid
    When I send a PUT request to modify the user's gender to "other"
    Then the response should have a status code of 200
    And the response should confirm the gender has been updated to "other"

    Scenario: Successfully update user's dateOfBirth
    Given the app-id "66271b536cae0377a3dee7c6" is authorized in the header
    And the user ID "60d0fe4f5311236168a109ca" is valid
    When I send a PUT request to modify the user's dateOfBirth to "13/05/2003"
    Then the response should have a status code of 200