package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

                            /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/json"
        And
            Status Line should be "HTTP/1.1 200 OK"
                           */


    @Test
    public void get01() {
        //a) Set the url (endpoint'i kur)
        String url = "https://restful-booker.herokuapp.com/booking/55";

        //b) Set the expected data (beklenen veriyi kur) ==> Bu adımı post ve put gibi data gönderilecek methodlarda yapacağız.


        //c) Send the request and get the response (request'i gönder ve response'ı al)
        Response response = given().get(url);
        response.prettyPrint();

        //d) Do assertion (Doğrulama yap)
        response.then().statusCode(200). // HTTP Status Code should be 200
                contentType("application/json"). // Content Type should be "application/json"
                statusLine("HTTP/1.1 200 OK"); // Status Line should be "HTTP/1.1 200 OK"

    }
}
