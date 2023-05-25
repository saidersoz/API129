package Get_Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class Get03 {

     /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
    "userId" is 2
   */

    @Test
    public void get03() {
        String url = "https://jsonplaceholder.typicode.com/todos/23";
        Response response = given().get(url);

        response.then().
                statusCode(200). // HTTP Status Code should be 200
                contentType("application/json"). // Response format should be "application/json"
                body("userId", equalTo(2)). //"userId" is 2
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")). //"title" is "et itaque necessitatibus maxime molestiae qui quas velit",
                body("completed", equalTo(false)); // "completed" is false

        //2.Yol
        response.then().statusCode(200).
                contentType(ContentType.JSON).
                body("userId", equalTo(2),
                        "title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false));


    }
}
