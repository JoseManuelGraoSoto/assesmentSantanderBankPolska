# DEVLOG

## Commit 1 – Project skeleton & README setup
**Date:** 2026-02-08  19:57

**Description:**
- Added basic project structure: `/src/main/java`, `/src/test/java`, `/src/test/resources/features`
- Created `pom.xml` with initial dependencies: Cucumber, RestAssured, JUnit
- Wrote README with installation instructions, project setup, and explanation of dependencies  
  **Reasoning:**
- Setup project skeleton to have a clear folder structure for framework code and tests
- Documented the environment setup so that anyone cloning the repo can run the project immediately

## Commit 2 – Add API client and config, Cucumber runner, first feature and step definitions
**Date:** 2026-02-09 11:22  

**Description:**
- Added **ApiConfig** class to centralize the base URL for the Joke API.
- Created **JokeApiClient** class with methods:
  - `getRandomJoke()` → calls `/random_joke` endpoint
  - `getPing()` → calls `/ping` endpoint to verify API is alive
- Added the first **feature file** to test:
  - Connection to the API (`/ping`)
  - Random joke endpoint (`/random_joke`)
- Created **Cucumber Runner (`RunnerTest`)** to execute feature files.
- Implemented initial **step definitions** for the first feature file:
  - Steps to call the endpoints
  - Assertions for HTTP response codes and basic response fields
- Updated **README.md** with instructions for environment setup, running tests, and explanation of project structure.

**Reasoning:**
- Provides the basic automation framework to call the API and validate main endpoints.
- Sets up the foundation for adding more feature files and step definitions in future commits.
- Keeps commits incremental: the project can now be cloned, set up, and run with one feature successfully.

## Commit 3 – Add Scenario Outline for joke by ID and step definitions
**Date:** 2026-02-09  11:44

**Description:**
- Added **feature file `jokeByID.feature`** with a **Scenario Outline** to test the `/jokes/{id}` endpoint for multiple IDs.
  - Example IDs: 1, 15, 47
  - Validates that the response status code is 200
  - Validates that the returned joke ID matches the requested ID
- Implemented **step definitions** in `JokeSteps.java` for this feature:
  - Step to request a joke by ID
  - Step to assert HTTP 200 response
  - Step to assert the joke ID matches the requested ID
- Updated **JokeApiClient** if needed to support `/jokes/{id}` requests.

**Reasoning:**
- Adds parameterized testing using Cucumber's Scenario Outline and Examples.
- Demonstrates ability to test multiple inputs without duplicating scenarios.
- Keeps commits incremental and readable: first feature was basic, now added multi-ID testing. 

## Commit 4 – Add feature and step definitions for retrieving ten random jokes
**Date:** 2026-02-09  12:01

**Description:**
- Added **new feature file `tenJokeValidation.feature`** to test the `/random_ten` endpoint.
  - Scenario validates that the API returns **exactly 10 jokes**.
  - Checks HTTP response code 200.
  - Verifies that each joke contains expected fields: `id`, `type`, `setup`, `punchline`.
- Implemented **step definitions** in `JokeSteps.java` for this feature:
  - Step to request ten random jokes using `getRandomTenJokes()`
  - Step to assert HTTP 200 response
  - Step to assert that the returned JSON array has length 10
- Updated **JokeApiClient** to include new method

## Commit 5 – Add response structure validation and negative/corner cases
**Date:** 2026-02-09 13:53

**Description:**
- Added **response structure validation** for `/random_joke` endpoint using **Cucumber DataTable**:
  - Verifies that all expected fields (`id`, `type`, `setup`, `punchline`) exist in the response
  - Checks field types (number/string) and patterns (e.g., `id > 0`, `setup` and `punchline` not empty)
  - Implemented Background step `Given the Joke API is available` to ensure API is up before scenarios
- Added **negative and corner case scenarios**:
  - Requesting a joke with invalid ID (e.g., `/jokes/0`)
  - Validates HTTP 404 status code
  - Validates that the `type` field in the response is `"error"`
- Updated **step definitions (`JokeSteps.java`)** to include:
  - Step to validate DataTable structure
  - Step to assert specific field values for negative tests

**Reasoning:**
- Ensures full coverage of **response validation** for key endpoints
- Demonstrates handling of **error responses** and corner cases
- Keeps commit incremental: adds structured validation and negative tests as a final layer on top of previous features  
