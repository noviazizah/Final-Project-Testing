Feature: User API Controller - Create User

  Background:
    Given I have access to the User API Controller

  Scenario: Successfully create a user with title "mr"
    Given I am authorized with a valid app-id "665b2b5479d0282f4782deae"
    And I have a user payload with title "mr" and other required fields
    When I send a POST request to "/user/create"
    Then I should receive a successful response with the status code 201
    And the response should display the user id and details

  Scenario: Successfully create a user with firstName having length between 2 and 50
    Given I am authorized with a valid app-id "665b2b5479d0282f4782deae"
    And I have a user payload with firstName length between 2 and 50
    When I send a POST request to "/user/create"
    Then I should receive a successful response with the status code 201
    And the response should display the user id and details

  Scenario: Successfully create a user with email as string
    Given I am authorized with a valid app-id "665b2b5479d0282f4782deae"
    And I have a user payload with email as string
    When I send a POST request to "/user/create"
    Then I should receive a successful response with the status code 201
    And the response should display the user id and details

  Scenario: Successfully create a user with dateOfBirth as ISO date
    Given I am authorized with a valid app-id "665b2b5479d0282f4782deae"
    And I have a user payload with dateOfBirth as ISO date
    When I send a POST request to "/user/create"
    Then I should receive a successful response with the status code 201
    And the response should display the user id and details

  Scenario: Successfully create a user with phone number in any format
    Given I am authorized with a valid app-id "665b2b5479d0282f4782deae"
    And I have a user payload with phone number in any format
    When I send a POST request to "/user/create"
    Then I should receive a successful response with the status code 201
    And the response should display the user id and details
