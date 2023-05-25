package Get_Requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {

    public static void main(String[] args) {

        /*
        1) Postman manuel test için kullanılır.
        2) Otomasyon için "Rest-Assured Library" kullanıyoruz.
        3) Otomasyonu yazabilmek için şu adımların izlenmesi gerekir.
               3.1) Gereksinimleri anlama.
               3.2) Test Case yazma.
                    --> Test yazmak için Gherkin Language kullanılır.
                    a)Given ==> Ön koşullar (Url, Body...)
                    b)When ==> Yapılacak işlemler (Get, Put, Post, Request...)
                    c)Then ==> Dönütler, çıktılar (Assertion, Close...)
                    d)End ==> Ard arda yapılan aynı çoklu işlemleri bağlamak için kullanılır
               3.3) Otomasyon kodlarını yazma.
                    a) Set the url (endpoint'i kur)
                    b) Set the expected data (beklenen veriyi kur)
                    c) Send the request and get the response (request'i gönder ve response'ı al)
                    d) Do assertion (Doğrulama yap)
         */

        //Get Request nasıl yapılır ?
        String url = "https://petstore.swagger.io/v2/pet/185321664841818";
        Response respone = given().get(url); //import static io.restassured.RestAssured.given;
        respone.prettyPrint(); //prettyPrint() methodu ile response'i konsola yazdırdık.

        //Status code nasıl yazdırılır ?
        System.err.println("Status Code : " + respone.statusCode()); // Status Code : 200

        //Content type nasıl yazdırılır ?
        System.err.println("Content Type : " + respone.contentType()); // Content Type : application/json

        //Status Line nasıl yazdırılır ?
        System.err.println("Status Line : " + respone.statusLine()); // Status Line : HTTP/1.1 200 OK


        //Header nasıl yazdırılır ?
        System.err.println("Header : " + respone.header("Date")); // Tue, 23 May 2023 18:52:02 GMT
        System.err.println("Header : " + respone.header("Connection")); // keep-alive
        System.err.println("Header : " + respone.header("Server")); // Jetty(9.2.9.v20150224)
        System.err.println("Header : " + respone.header("Transfer-Encoding")); // chunked


        //Headers nasıl yazdırılır ?
        System.out.println(respone.headers());

        //Time nasıl yazdırılır ?
        System.out.println("\ntime :"+respone.time());


    }

}
