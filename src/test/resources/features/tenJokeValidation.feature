Feature: Random joke endpoint

  Background:
    Given the Joke API is available

  Scenario: Get ten random jokes and verify quantity
    When I request ten random jokes
    Then the response status code should be 200
    Then the response should contain 10 jokes