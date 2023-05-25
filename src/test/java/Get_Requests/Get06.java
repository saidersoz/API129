package Get_Requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get06 extends HerokuAppBaseUrl {

     /*
  Given
      https://restful-booker.herokuapp.com/booking/23
  When
      User send a GET request to the URL
  Then
      HTTP Status Code should be 200
  And
      Response content type is "application/json"
  And
      Response body should be like;
           {
              "firstname": "Josh",
              "lastname": "Smith",
              "totalprice": 111,
              "depositpaid": true,
              "bookingdates": {
                  "checkin": "2018-01-01",
                  "checkout": "2019-01-01"
              },
              "additionalneeds": "super bowls"
           }
*/

    @Test
    public void get06() {
        //set the url
        spec.pathParams("first", "booking", "second", 23);

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //assertion
        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Josh"),
                        "lastname", equalTo("Allen"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds",equalTo("super bowls"));
    }

    @Test
    public void test06() {
        //Set the url
        spec.pathParams("first", "booking", "second", 23);

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
    }
}
