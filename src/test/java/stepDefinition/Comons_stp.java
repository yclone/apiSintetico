package stepDefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;

public class Comons_stp {

    private static String url;

    public static String getUrl() {
        return url;
    }
    public static void setUrl(String url) {
        Comons_stp.url = url;
    }

    @Dado("que eu acesse a API {string}")
    public void queEuAcesseOSistema(String arg0) {
        setUrl(arg0);
    }

}
