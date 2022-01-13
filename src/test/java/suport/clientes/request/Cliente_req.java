package suport.clientes.request;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Cliente_req {

    public Response Get_cliente(String url){
        useRelaxedHTTPSValidation();
        Response res = null;
//        RequestSpecification requestSpec= RestAssured.given().baseUri("Some Base URI").basePath("/SomeBasePath");
        try {
            res = given()
//                    .proxy("http.proxy", 8080)
//                    .header("apikey", "apikey")
                    .baseUri(url)
                    .basePath("/clientes/list")
                    .header("Content-Type", "application/json")
//                    .when().log().all()
                    .get();
        }catch (Exception e){
            System.err.println(e);
        }
        return res;
    }

    public Response Post_cliente(String url, String jsonData){
        useRelaxedHTTPSValidation();
        Response res = null;
        try {
            res = given()
                    .baseUri(url)
                    .basePath("/clientes/create")
                    .header("Content-Type", "application/json")
                    .when()
//                    .log().all()
                    .post();
        }catch (Exception e) {
            System.err.println(e);
        }
        return res;
    }
}
