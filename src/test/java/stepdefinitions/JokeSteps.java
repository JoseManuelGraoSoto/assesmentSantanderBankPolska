package stepdefinitions;

import api.client.JokeApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

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
    @When("I request a joke with id {int}")
    public void iRequestAJokeWithId(int id) {
        response = jokeApiClient.getJokeById(id);
    }

    @When("I request a random joke")
    public void iRequestARandomJoke() {
        response = jokeApiClient.getRandomJoke();
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
        assertEquals(expectedId, actualId);
    }
}

