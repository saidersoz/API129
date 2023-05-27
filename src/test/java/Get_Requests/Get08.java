package Get_Requests;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

public class Get08 extends JsonPlaceHolderBaseUrl {

    /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false
       }
*/


    @Test
    public void get08() {
        //set the url
        spec.pathParams("first", "todos", "second", 2);

        //Set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obj.expectedDataMapMethod(1, "quis ut nam facilis et officia qui", false);
        System.out.println("expectedData = " + expectedData);
    }
}
