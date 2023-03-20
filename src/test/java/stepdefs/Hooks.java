package stepdefs;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import utils.ConfigReader;

public class Hooks {

    // @Before - is a Cucumber library annotation
    // when method is marked as @Before - it will execute before each Scenario in our Feature files
    // each Feature file will include the CRUD operation methods:
    // Create = POST Request
    // Read = GET Request
    // Update = PUT/PATCH Request
    // Delete = DELETE Request
    // as we know - we have to provide authorization token before sending the Request to the server
    @BeforeEach
    public static void setUp() {

        // calling .initializeProperties() method to read the config.properties file and to get the values for the following keys: "api.host" and "api.version"
        ConfigReader.initializeProperties();

        // re-assigning the RestAssured "baseURI" variable value from the default one to what we will need: https://gorest.co.in/public/v2
        RestAssured.baseURI = ConfigReader.getConfigProperty("api.host") + ConfigReader.getConfigProperty("api.version");
    }
}
