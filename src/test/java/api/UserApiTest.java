package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class UserApiTest {

    @Test
    public void getUsersShouldReturn200() {
        RestAssured
            .given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/users")
            .when()
                .get()
            .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0));
    }
}