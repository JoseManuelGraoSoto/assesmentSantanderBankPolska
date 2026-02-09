Feature: Negative test for joke by ID

  Background:
    Given the Joke API is available

  Scenario Outline: Retrieve a joke by id
    When I request a joke with id <id>
    Then the response status code should be 404
    And the response field "type" should be "error"


    Examples:
      | id  |
      | -15 |
      | 0   |