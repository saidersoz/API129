package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuAppBaseUrl {

    //setUp methodu ile tekrarlı yapılacak işlemleri topluyoruz. Ve test öncesi çalışacak şekilde @Before anotasyonu ekliyoruz.

    protected RequestSpecification spec;

    @Before //Her test methodu öncesi çalışır
    public void setUp() throws Exception {
        spec = new RequestSpecBuilder().setAccept(ContentType.JSON).setBaseUri("https://restful-booker.herokuapp.com/").build();
    }
}
