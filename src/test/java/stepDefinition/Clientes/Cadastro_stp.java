package stepDefinition.Clientes;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import stepDefinition.Comons_stp;
import suport.cadastro.test.Cadastro_tests;

public class Cadastro_stp {

    Cadastro_tests cadastro_tests;


    @Quando("eu insiro um cadastro novo")
    public void euInsiroUmClienteNovo() {
        cadastro_tests = new Cadastro_tests();
        cadastro_tests.cadastroNovo(Comons_stp.getUrl());
    }

    @Entao("o status code do cadastro deve ser {string}")
    public void oStatusCodeDoCadastroDeveSer(String arg0) {
        cadastro_tests.ValidaStatusCode(arg0);
    }
}
