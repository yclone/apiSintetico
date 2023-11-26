package suport.cadastro.test;

import comons.JsonManager;
import io.restassured.response.Response;
import suport.cadastro.request.Cadastro_req;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

public class Cadastro_tests extends Cadastro_req {

    Response response;

    public Cadastro_tests() {
    }

    public void consultaCliente(String url) {
        response = Get_Cadastro(url);
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

    public void cadastroNovo(String url) {
        byte[] array = new byte[7]; // length is bounded by 7
        int alphabetSize = 26;

        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) (new Random().nextInt(alphabetSize) + 'a');
        }

        String generatedString = new String(array, Charset.forName("UTF-8"));

        String jsonvalido = null;
        try {
            JsonManager jsonManager = new JsonManager("MassaCadastro.json");
            jsonManager.alterarCampoDaRaiz("username", generatedString);
            jsonManager.alterarCampoDaRaiz("email", generatedString + "@teste.com");
            jsonManager.alterarCampoDaRaiz("nome", generatedString);
            jsonManager.alterarCampoDaRaiz("sobrenome", generatedString);
            jsonManager.alterarCampoDaRaiz("password", "123@" + generatedString);
            jsonvalido = jsonManager.jsonValido();
        } catch (IOException e){
            System.err.println(e);
        }
        System.out.println(jsonvalido);

        response = Post_cadastro(url, jsonvalido);
    }
}
