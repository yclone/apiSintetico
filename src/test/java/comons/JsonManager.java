package comons;


import com.google.gson.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonManager {

    private Reader reader;
    private JsonElement jelement;
    private String contents;

    private JsonObject jsonObject;
    private JsonArray jsonArray;

    public JsonManager(String caminho) throws IOException {
        caminho = "src/test/resources/massas/" + caminho;
        reader = Files.newBufferedReader(Paths.get(caminho));
        Path path = Paths.get(caminho);
        try {
            contents = Files.readString(path, StandardCharsets.ISO_8859_1);
        } catch (IOException ex) {
            // Handle exception
        }
        Gson gson = new Gson();
        jelement = gson.fromJson(contents, JsonElement.class);
        if (jelement instanceof JsonObject) {
            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        } else if (jelement instanceof JsonArray) {
            jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
        }
    }

    public String jsonValido() throws IOException {
        if(jsonObject == null){
            return jsonArray.toString();
        } else {
            return jsonObject.toString();
        }
    }

    public String alterarCampoDaRaiz(String nomeDoCampo, String data) throws IOException {
        jsonObject.addProperty(nomeDoCampo, data);
        return jsonObject.toString();
    }
}
