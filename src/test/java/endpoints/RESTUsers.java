package endpoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import pojos.UsersPojo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RESTUsers extends RESTBase {
    // here we are simply verifying whether there is already an existing instance of this Class, and only if there is none - we will create a new one
    private static RESTUsers instance = null;
    private RESTUsers() {
    }
    public static RESTUsers getInstance() {
        if (instance == null) {
            instance = new RESTUsers();
        }
        return instance;
    }

    /*
        Automating POST Request - writing a script for a method, which will send a POST Request to a server and create our User Object ina Database:
        What do we need? - Request URL (BaseUrl), Authorization token, body
        1. BaseUrl is inside the .setUp() method inside our "Hooks.java" Class, and since the method is marked with @Before annotation - it will execute before each scenario
        2. Authorization variable is initialized inside our "RESTBase.java" Class that our current Class extends, so we just need to pass it inside the ".header()" method
        3. The design template for our Request body is already created in "UsersPojo.java" Class, so we will just create an Object of it and pass necessary arguments to the Constructor
     */

    String name = FAKER.name().fullName();
    String email = FAKER.internet().emailAddress();
    UsersPojo serializedUser = new UsersPojo(name, email, "female", "inactive");
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    public String currentUserId = "";
    UsersPojo deserializedUser;

    public void createUserResponse (String AUTH, String jsonBody){
        // createUsersResponse variable is used to store the Response we will be receiving from the server
        // it will be printed out to the console with the help of .toSting() method that we are overriding
        // a prt of our testing is verifying the Status Code and making sure the fields and values of the body are correct
        Response createUsersResponse = RestAssured
                // arrange part:
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + AUTH)
                .accept(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post();

    }




}
