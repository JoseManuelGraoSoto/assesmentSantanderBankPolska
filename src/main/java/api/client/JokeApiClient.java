package api.client;

import api.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JokeApiClient {

    /*
    app.get('/random_joke', (req, res) => {
      res.json(randomJoke());
    });
     */
    public Response getRandomJoke() {
        return RestAssured.given()
                .baseUri(ApiConfig.BASE_URL)
                .when()
                .get("/random_joke");
    }

    /*
    app.get('/ping', (req, res) => {
        res.send('pong');
    });
     */
    public Response getPing() {
        return RestAssured.given()
                .baseUri(ApiConfig.BASE_URL)
                .when()
                .get("/ping");
    }
}

