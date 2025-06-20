package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class PostUserTest {

    @Test
    public void createUserReturnsSuccess() {
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1") // <- Header necessário agora
                .body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
                .when()
                .post()
                .then()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }
}