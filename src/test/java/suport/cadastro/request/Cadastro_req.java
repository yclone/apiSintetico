package suport.cadastro.request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class Cadastro_req {

    public Response Get_Cadastro(String url){
        useRelaxedHTTPSValidation();
        Response res = null;
//        RequestSpecification requestSpec= RestAssured.given().baseUri("Some Base URI").basePath("/SomeBasePath");
        try {
            res = given()
//                    .proxy("http.proxy", 8080)
//                    .header("apikey", "apikey")
                    .baseUri(url)
                    .basePath("/user")
                    .header("Content-Type", "application/json")
//                    .when().log().all()
                    .get();
        }catch (Exception e){
            System.err.println(e);
        }
        return res;
    }

    public Response Post_cadastro(String url, String jsonData){
        useRelaxedHTTPSValidation();
        Response res = null;
        try {
            res = given()
                    .baseUri(url)
                    .basePath("/user")
                    .header("Content-Type", "application/json")
                    .when()
//                    .log().all()
                    .body(jsonData)
                    .post();
        }catch (Exception e) {
            System.err.println(e);
        }
        return res;
    }
}
