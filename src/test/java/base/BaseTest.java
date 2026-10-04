package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    protected RequestSpecification request() {

        return RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Content-Type", "application/json");
    }
}