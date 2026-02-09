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