Feature: Validate joke response structure

  Background:
    Given the Joke API is available

  Scenario: Random joke response structure
    When I request a random joke
    Then the response status code should be 200
    And the response should contain the following fields:
      | field     | type   | pattern |
      | id        | number | >0      |
      | type      | string | ANY     |
      | setup     | string | .+      |
      | punchline | string | .+      |