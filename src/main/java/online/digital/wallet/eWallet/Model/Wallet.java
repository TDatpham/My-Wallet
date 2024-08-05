package online.digital.wallet.eWallet.Model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "balance")
    private double balance;

    @Column(name = "owner", nullable = false)
    private String owner;

    @JsonIgnore
    @OneToOne
    @JoinColumn
    private User user;   
    
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> transactions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public void setBalance(double updatedBalance) {
		// TODO Auto-generated method stub
		this.balance=updatedBalance;
	}
	
	public void setTransaction(List<Transaction> transactions) {
		// TODO Auto-generated method stub
		this.transactions=transactions;
	}
	
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return transactions;
	}

	public static Builder builder() {
		// TODO Auto-generated method stub
		return new Builder();
	}
	   
	public static class Builder {
        private User user;
        private int id;
        private int balance;
        private String owner;

        public Builder user(User user) {
            this.user = user;
            return this;
        }
        
        public Builder id(int id) {
            this.id = id;
            return this;
        }
        
        public Builder balance(int surprizeBalance) {
            this.balance = surprizeBalance;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public Wallet build() {
            Wallet wallet = new Wallet();
            wallet.user = this.user;
            wallet.id = this.id;
            wallet.balance = this.balance;
            wallet.owner = this.owner;
            return wallet;
        }
    }
}
