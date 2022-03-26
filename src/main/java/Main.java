import entity.TokenAccountBalance;
import service.EtherScanApiService;
import service.PropertiesService;
import service.TelegramApiService;

public class Main {

    public static void main(String[] args) {
        PropertiesService propertiesService = new PropertiesService();
        for (; ; ) {
            TokenAccountBalance tokenAccountBalance = EtherScanApiService.getTokenBalance(
                    propertiesService.getContractAddress(), propertiesService.getAddress()
            );
            if (tokenAccountBalance.getTokenBalanceAsDouble() >= 10D) {
                String message = tokenAccountBalance.getTokenBalanceAsDouble() + "%20" + propertiesService.getTokenSymbol();
                TelegramApiService.sendNotification(message);
            }
            try {
                Thread.sleep(propertiesService.getPollingIntervalInMin() * 60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
