package Get_Requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get09 extends HerokuAppBaseUrl {

                        /*
         Given
             https://restful-booker.herokuapp.com/booking/215
         When
             I send GET Request to the url
         Then
             Response body should be like that;
        {
         "firstname": "John",
         "lastname": "Smith",
         "totalprice": 111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2018-01-01",
             "checkout": "2019-01-01"
         },
         "additionalneeds": "Breakfast"
         }
                      */

    @Test
    public void get09() {
        //set the url
        spec.pathParams("first", "booking", "second", 798);

        //set the expected data
        Map<String, String> bookingdatesMap = new HashMap<>(); //Önce inner map oluşturulur
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "John");
        expectedData.put("lastname", "Smith");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", bookingdatesMap);
        expectedData.put("additionalneeds", "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }
}
