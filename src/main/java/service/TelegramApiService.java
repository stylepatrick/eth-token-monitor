package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TelegramApiService {

    public static void sendNotification(String notification) {
        PropertiesService propertiesService = new PropertiesService();

        String telegramBotUrl = "https://api.telegram.org/" +
                "bot" + propertiesService.getBotToke() + "/sendMessage?chat_id=" + propertiesService.getChatId() + "&text=";

        String messageUrl = telegramBotUrl + notification;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(messageUrl))
                .GET()
                .build();

        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
