package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class UserApiScenarios {

    private static final String API_KEY = "reqres-free-v1";

    @Test
    public void listUsersPage2() {
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .queryParam("page", 2)
                .header("x-api-key", API_KEY)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("data", not(empty()))
                .body("page", equalTo(2));
    }

    @Test
    public void successfulRegistration() {
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("/api/register")
                .contentType(ContentType.JSON)
                .header("x-api-key", API_KEY)
                .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }")
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }

    @Test
    public void failedRegistrationMissingPassword() {
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("/api/register")
                .contentType(ContentType.JSON)
                .header("x-api-key", API_KEY)
                .body("{ \"email\": \"eve.holt@reqres.in\" }")
                .when()
                .post()
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    @Test
    public void deleteUserReturns204() {
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .header("x-api-key", API_KEY)
                .when()
                .delete()
                .then()
                .statusCode(204);
    }

    @Test
    public void updateUserReturnsUpdatedAt() {
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .contentType(ContentType.JSON)
                .header("x-api-key", API_KEY)
                .body("{ \"name\": \"rogerio\", \"job\": \"qa lead\" }")
                .when()
                .put()
                .then()
                .statusCode(200)
                .body("name", equalTo("rogerio"))
                .body("job", equalTo("qa lead"))
                .body("updatedAt", notNullValue());
    }
}