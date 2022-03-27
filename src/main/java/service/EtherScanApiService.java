package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.TokenAccountBalance;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EtherScanApiService {

    public static TokenAccountBalance getTokenBalance(String contractAddress, String address) {
        String etherScanEndpoint = PropertiesService.etherScanApi + "/api?module=account&action=tokenbalance" +
                "&contractaddress=" + contractAddress +
                "&address=" + address +
                "&tag=latest&apikey=" + PropertiesService.etherScanApiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(etherScanEndpoint))
                .GET()
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(
                    request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(response.body(), TokenAccountBalance.class);
    }

}
