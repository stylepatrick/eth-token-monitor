package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesService {

    private static final String env = "app-dev.properties";

    public static String etherScanApi;
    public static String etherScanApiKey;
    public static String botToke;
    public static String chatId;
    public static String contractAddress;
    public static String address;
    public static String tokenSymbol;
    public static Integer pollingIntervalInMin;

    public static void initProperties() {
        InputStream stream = PropertiesService.class
                .getClassLoader()
                .getResourceAsStream(env);

        Properties appProps = new Properties();

        try {
            appProps.load(stream);
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
