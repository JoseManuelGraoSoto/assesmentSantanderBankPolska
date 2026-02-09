Feature: Random joke endpoint

  Background:
    Given the Joke API is available

  Scenario: Get a random joke and verify response structure
    When I request a random joke
    Then the response status code should be 200
    And the joke response should contain id, type, setup and punchline