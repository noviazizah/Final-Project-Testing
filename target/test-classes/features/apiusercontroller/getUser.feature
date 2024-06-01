Feature: User API Controller - Get User by ID

  Background:
    Given I have access to the User API

 Scenario: Get user with a valid and registered user ID
    Given I have a valid app-id in the header "665b2b5479d0282f4782deae"
    When I send a GET request to "/user/{id}" with user ID "60d0fe4f5311236168a109fa"
    Then I should receive a 200 status code
    And the response should contain the user details

  Scenario: Get user with a valid but unregistered user ID
    Given I have a valid app-id in the header "60d0fe4f5311236168a109fa"
    When I send a GET request to "/user/{id}" with user ID "60d0fe4f5311236168a202ca"
    Then I should receive a 404 status code
    And the response should contain an error message about "RESOURCE_NOT_FOUND"

  Scenario: Get user with an invalid user ID
    Given I have a valid app-id in the header "665b2b5479d0282f4782deae"
    When I send a GET request to "/user/{id}" with user ID "60d0fe4f5"
    Then I should receive a 400 status code
    And the response should contain an error message about "PARAMS_NOT_VALID"

  Scenario: Get user without setting app-id in the request header
    Given I dont have an app-id in the header
    When I send a GET request to "/user/{id}" with user ID "60d0fe4f5311236168a109fa"
    Then I should receive a 403 status code
    And the response should contain an error message about "APP_ID_MISSING"

  Scenario: Get user with an invalid app-id in the request header
    Given I have an invalid app-id in the header "662e0effbb70a725c3259220"
    When I send a GET request to "/user/{id}" with user ID "60d0fe4f5311236168a109fa"
    Then I should receive a 403 status code
    And the response should contain an error message about "APP_ID_NOT_EXIST"
