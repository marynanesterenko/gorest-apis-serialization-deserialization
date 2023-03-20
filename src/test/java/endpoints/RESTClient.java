package endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// "RESTClient.java" Class will hold reusable methods
// method structure:
// 1.


public class RESTClient {

    public Response createUser(String AUTH, String jsonBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/users");
    }

    public Response getUserById(String AUTH, String userId) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .when()
                .pathParam("userId", userId)
                .get("/users/{userId}");
    }

    public Response getUsers(String AUTH) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .when()
                .get("/users");
    }

    public Response updateUserById(String AUTH, String body, String userId) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .pathParam("userId", userId)
                .put("/users/{userId}");
    }

    public Response deleteUserById(String AUTH, String userId) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .when()
                .pathParam("userId", userId)
                .delete("/users/{userId}");
    }
}
