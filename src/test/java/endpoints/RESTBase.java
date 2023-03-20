package endpoints;

import com.github.javafaker.Faker;
import utils.ConfigReader;

public class RESTBase {
    public final Faker FAKER = new Faker();
    public final String AUTH = ConfigReader.getConfigProperty("api.auth");
}
