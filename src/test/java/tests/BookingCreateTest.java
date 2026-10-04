package tests;

import base.BaseTest;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BookingCreateTest extends BaseTest {

    @Test
    public void createBooking() {

        String requestBody = """
                {
                    "firstname": "Sdet",
                    "lastname": "Assignment",
                    "totalprice": 150,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2035-06-10",
                        "checkout": "2035-06-15"
                    },
                    "additionalneeds": "Breakfast"
                }
                """;

        request()

                .body(requestBody)

                .when()
                .post("/booking")

                .then()
                .statusCode(200)
                .body("bookingid", Matchers.notNullValue())
                .body("booking.firstname", Matchers.equalTo("Sdet"))
                .body("booking.lastname", Matchers.equalTo("Assignment"))
                .body("booking.totalprice", Matchers.equalTo(150))
                .body("booking.depositpaid", Matchers.equalTo(true))
                .body("booking.bookingdates.checkin", Matchers.equalTo("2035-06-10"))
                .body("booking.bookingdates.checkout", Matchers.equalTo("2035-06-15"))
                .body("booking.additionalneeds", Matchers.equalTo("Breakfast"))
                .log()
                .all();
    }
}