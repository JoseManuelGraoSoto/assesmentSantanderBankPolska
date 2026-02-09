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
    /*
    app.get('/jokes/:id', (req, res, next) => {
        try {
            const { id } = req.params;
            const joke = jokeById(+id);
            if (!joke) return next({ statusCode: 404, message: 'joke not found' });
            return res.json(joke);
        } catch (e) {
            return next(e);
        }
    });
     */
    public Response getJokeById(int id) {
        return RestAssured.given()
                .baseUri(ApiConfig.BASE_URL)
                .pathParam("id", id)
                .when()
                .get("/jokes/{id}");
    }
}

