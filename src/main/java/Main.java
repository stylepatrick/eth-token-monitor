import entity.TokenAccountBalance;
import service.EtherScanApiService;
import service.PropertiesService;
import service.TelegramApiService;

public class Main {

    public static void main(String[] args) {
        PropertiesService.initProperties();
        TokenAccountBalance balance = new TokenAccountBalance();
        TokenAccountBalance prevBalance = new TokenAccountBalance();

        for (; ; ) {
            balance = EtherScanApiService.getTokenBalance(
                    PropertiesService.contractAddress, PropertiesService.address
            );
            if (prevBalance.getResult() != null &&
                    !prevBalance.getResult().equals(balance.getResult())) {
                String message = balance.getTokenBalanceAsDouble() + "%20" + PropertiesService.tokenSymbol;
                TelegramApiService.sendNotification(message);
            }
            prevBalance = balance;
            try {
                Thread.sleep(PropertiesService.pollingIntervalInMin * 60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
