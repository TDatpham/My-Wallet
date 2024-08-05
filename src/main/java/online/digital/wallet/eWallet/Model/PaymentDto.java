package online.digital.wallet.eWallet.Model;


import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private String fromUser;
    private String toUser;
    private double amount;

    @Override
    public String toString() {
        return "PaymentDto [fromUser=" + fromUser + ", toUser=" + toUser + ", amount=" + amount + "]";
    }
    
    public void setFromUser(String fromUser) {
        this.fromUser=fromUser;
    }
    
	public String getFromUser() {
		// TODO Auto-generated method stub
		return fromUser;
	}
	
    public void setToUser(String toUser) {
        this.toUser=toUser;
    }
	
	public String getToUser() {
		// TODO Auto-generated method stub
		return toUser;
	}
	
    public void setAmount(double amount) {
        this.amount=amount;
    }
	
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}
}
