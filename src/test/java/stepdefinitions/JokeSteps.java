package stepdefinitions;

import api.client.JokeApiClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JokeSteps {

    private final JokeApiClient jokeApiClient = new JokeApiClient();
    private Response response;

    @Given("the Joke API is available")
    public void theJokeApiIsAvailable() {
        response = jokeApiClient.getPing();
        response.then().statusCode(200);
        String body = response.getBody().asString();
        assertEquals("pong", body);
    }
    @When("I request a random joke")
    public void iRequestARandomJoke() {
        response = jokeApiClient.getRandomJoke();
    }

    @When("I request ten random jokes")
    public void iRequestTenRandomJoke() {response = jokeApiClient.getRandomTenJokes();}

    @When("I request a joke with id {int}")
    public void iRequestAJokeWithId(int id) {
        response = jokeApiClient.getJokeById(id);
    }

    @Then("the response should contain {int} jokes")
    public void theResponseShouldContainNumberOfJokes(int expectedCount) {

        List<Map<String, Object>> jokes = response.jsonPath().getList("$");
        assertThat("Number of jokes returned", jokes.size(), equalTo(expectedCount));
    }

    @Then("the response should contain the following fields:")
    public void response_should_contain_fields(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String field = row.get("field");
            String type = row.get("type");
            String pattern = row.get("pattern");

            Object value = response.jsonPath().get(field);
            assertNotNull("Field " + field + " should exist", value);

            switch (type.toLowerCase()) {
                case "number":
                    assertTrue(field + " should be a number", value instanceof Integer);
                    int intValue = (Integer) value;
                    assertTrue(field + " should be > " + 0, intValue > 0);
                    break;
                case "string":
                    assertTrue(field + " should be a string", value instanceof String);
                    String strValue = (String) value;

                    if ("ANY".equals(pattern)) {
                        List<String> validTypes = List.of("general", "programming");
                        assertTrue(field + " should be one of " + validTypes, validTypes.contains(strValue));
                    } else
                        assertTrue(field + " should match pattern", strValue.matches(pattern));
                    break;
                default:
                    fail("Unknown type: " + type);
            }
        }
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the joke response should contain id, type, setup and punchline")
    public void theJokeResponseShouldContainExpectedFields() {
        response.then()
                .body("id", notNullValue())
                .body("type", notNullValue())
                .body("setup", notNullValue())
                .body("punchline", notNullValue());
    }

    @Then("the joke id should be {int}")
    public void theJokeIdShouldBe(int expectedId) {
        int actualId = response.jsonPath().getInt("id");
        assertThat(actualId, equalTo(expectedId));
    }

    @Then("each joke should contain the following fields:")
    public void eachJokeShouldContainTheFollowingFields(DataTable dataTable) {
        List<String> fields = dataTable.asList();

        for (String field : fields) {
            response.then()
                    .body("every { it.containsKey('" + field + "') }", is(true));
        }
    }

    @Then("the response field {string} should be {string}")
    public void theResponseFieldShouldBe(String field, String expectedValue) {
        String actualValue = response.jsonPath().getString(field);
        assertEquals(field + " should match expected value", expectedValue, actualValue);
    }
}

