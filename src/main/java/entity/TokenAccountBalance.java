package entity;

import lombok.Getter;
import org.web3j.utils.Convert;

@Getter
public class TokenAccountBalance {

    private String status;
    private String message;
    private String result;

    public Double getTokenBalanceAsDouble() {
        return Convert.fromWei(String.valueOf(Double.parseDouble(this.result)), Convert.Unit.ETHER).doubleValue();
    }

}
