package suport.clientes.test;

import comons.JsonManager;
import io.restassured.response.Response;
import suport.clientes.request.Cliente_req;

import java.io.IOException;

public class Cliente_stp extends Cliente_req {

    Response response;

    public Cliente_stp() {
    }

    public void consultaCliente(String url) {
        response = Get_cliente(url);
        System.out.println("QTD DE CLIENTES CADASTRADOS: " + response.then().extract().path("list.size()").toString());
    }

    public Boolean ValidaLista() {
        int tam = response.then().extract().path("list.size()");
        if (tam > 0){
            return true;
        } else {
            return false;
        }
    }

    public void ValidaStatusCode(String code) {
        response.then().statusCode(Integer.parseInt(code));
    }

    public void InsereCliente(String url, String arg0, String fileName) {
        String jsonvalido = null;
        try {
            JsonManager jsonManager = new JsonManager(fileName);
            jsonManager.alterarCampoDaRaiz("nome", arg0);
            jsonvalido = jsonManager.jsonValido();
        } catch (IOException e){
            System.err.println(e);
        }
        System.out.println(jsonvalido);
        response = Post_cliente(url, jsonvalido);
//        response.then().log().all();
    }
}
