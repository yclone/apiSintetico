package stepDefinition.Clientes;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import stepDefinition.Comons_stp;
import suport.clientes.test.Cliente_tests;

public class Clientes_stp {

    Cliente_tests cliente;

    @Quando("eu consulto a lista de clientes")
    public void euConsultoAListaDeClientes() {
        cliente = new Cliente_tests();
        cliente.consultaCliente(Comons_stp.getUrl());
    }

    @Entao("devo apresentar a lista de clientes cadastrados no sistema")
    public void devoApresentarAListaDeClientesCadastradosNoSistema() {
        Assert.assertEquals(cliente.ValidaLista(), true);
    }

    @E("o status code deve ser {string}")
    public void oStatusCodeDeveSer(String arg0) {
        cliente.ValidaStatusCode(arg0);
    }

    @Quando("eu insiro um cliente com o Nome {string}")
    public void euInsiroUmClienteComONome(String arg0) {
        cliente = new Cliente_tests();
        cliente.InsereCliente(Comons_stp.getUrl(), arg0, "MassaUsuario.json");
    }


}
