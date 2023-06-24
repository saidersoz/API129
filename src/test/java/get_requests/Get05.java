package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerokuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
              (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
 */

    @Test
    public void Get05() {

        spec.pathParam("first","booking").
                queryParams("firstname","Sally","lastname","Brown");

        Response response = given(spec).accept(ContentType.JSON).get("{first}");
        response.prettyPrint();


        response.then().statusCode(200).body("bookingid",hasSize(greaterThan(0)));

        //yada
        assertTrue(response.asString().contains("bookingid"));
    }
}
