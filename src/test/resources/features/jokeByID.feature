Feature: Joke by ID endpoint

  Background:
    Given the Joke API is available

  Scenario Outline: Retrieve a joke by id
    When I request a joke with id <id>
    Then the response status code should be 200
    And the joke id should be <id>

    Examples:
      | id |
      | 1  |
      | 15 |
      | 47 |