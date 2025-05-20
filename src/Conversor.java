import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Conversor {

    public Moeda conversor (String api, String moeda) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + api + "/latest/" + moeda);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moeda.class);

        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter sua conversão!!");
        }
    }
}