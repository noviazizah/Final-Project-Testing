Feature: User API Controller - Delete User by ID

  Background:
    Given I have access to the API User Controller

  Scenario: Successfully delete a user with a valid and registered ID
    Given I have a valid app-id "665b2b5479d0282f4782deae"
    When I send a DELETE request to "/user/{id}" with user ID "60d0fe4f5311236168a109ff"
    Then I should receive success with status code 200
     And the response should display the user id


  Scenario: Attempt to delete a user with a valid but unregistered ID
    Given I have a valid app-id "665b2b5479d0282f4782deae"
    When I send a DELETE request to "/user/{id}" with user ID "60d0fe4f5311236168a202ca"
    Then I should receive an error with status code 404
    And the response should display an error "RESOURCE_NOT_FOUND"

  Scenario: Attempt to delete a user with an invalid user ID
    Given I have a valid app-id "665b2b5479d0282f4782deae"
    When I send a DELETE request to "/user/{id}" with user ID "60d0fe4f5"
    Then I should receive an error with status code 400
    And the response should display an error "PARAMS_NOT_VALID"

  Scenario: Attempt to delete a user without setting app-id in the header
    Given I dont have an app-id
    When I send a DELETE request to "/user/{id}" without app-id and with user ID "60d0fe4f5311236168a109ff"
    Then I should receive an error with status code 403
    And the response should display an error "APP_ID_MISSING"

  Scenario: Attempt to delete a user with an invalid app-id in the header
    Given I have an invalid app-id "662e0effbb70a725c3259220"
    When I send a DELETE request to "/user/{id}" with user ID "60d0fe4f5311236168a109ff"
    Then I should receive an error with status code 403
    And the response should display an error "APP_ID_NOT_EXIST"
