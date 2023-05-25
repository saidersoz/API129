package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    //setUp methodu ile tekrarlı yapılacak işlemleri topluyoruz. Ve test öncesi çalışacak şekilde @Before anotasyonu ekliyoruz.

    protected RequestSpecification spec;

    @Before //Her test methodu öncesi çalışır
    public void setUp() throws Exception {
        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/").build();
    }
}
