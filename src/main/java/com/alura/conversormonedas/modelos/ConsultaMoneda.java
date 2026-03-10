package com.alura.conversormonedas.modelos;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public double buscarTasa(String monedaBase, String monedaDestino) {
        String apiKey = "797c1869eff8dedbf5724c0a";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaBase + "/" + monedaDestino;

        // Implementamos try-with-resources para el HttpClient (Nota los paréntesis)
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("La API respondió con error. Código: " + response.statusCode());
            }

            Gson gson = new Gson();
            TasaDeCambio miMoneda = gson.fromJson(response.body(), TasaDeCambio.class);

            return miMoneda.conversion_rate();

        } catch (Exception e) {
            throw new RuntimeException("No pude obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
