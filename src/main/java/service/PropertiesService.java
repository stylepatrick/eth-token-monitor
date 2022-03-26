package service;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
public class PropertiesService {

    private final String etherScanApi;
    private final String etherScanApiKey;
    private final String botToke;
    private final String chatId;
    private final String contractAddress;
    private final String address;
    private final String tokenSymbol;
    private final Integer pollingIntervalInMin;

    public PropertiesService() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "app.properties";
        //String appConfigPath = rootPath + "app-dev.properties";
        Properties appProps = new Properties();

        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        etherScanApi = appProps.getProperty("etherScanApi");
        etherScanApiKey = appProps.getProperty("etherScanApiKey");
        botToke = appProps.getProperty("botToke");
        chatId = appProps.getProperty("chatId");
        contractAddress = appProps.getProperty("contractAddress");
        address = appProps.getProperty("address");
        tokenSymbol = appProps.getProperty("tokenSymbol");
        pollingIntervalInMin = Integer.valueOf(appProps.getProperty("pollingIntervalInMin"));

    }
}
