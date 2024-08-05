package online.digital.wallet.eWallet.Model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.*;

@Entity
@Table(name = "txns")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "txn_id")
    private String txn_Id;

    @Column(name = "from_user")
    private String fromUser;

    @Column(name = "to_user")
    private String toUser;


    @Column(name = "amount")
    private double amount;

    @Column(name = "transaction_status")
    private TransactionStatus transactionStatus;

    @Column(name = "created_on")
    private String createdOn;

    @ManyToOne
    @JoinColumn
    private Wallet wallet;

	public String someOtherField;

	public String timestamp;
	
	public String getCreatedOn() {
		return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn=createdOn;
    }
	
	public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount=amount;
    }
    
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }
    
    public String getTxn_Id() {
        return txn_Id;
    }

    public void setTxn_Id(String txn_Id) {
        this.txn_Id=txn_Id;
    }
    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser=fromUser;
    }
    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser=toUser;
    }
	public TransactionStatus getTransactionStatus() {
		// TODO Auto-generated method stub
		return transactionStatus;
	}

	
	public void setTransactionStatus(TransactionStatus successful) {
		// TODO Auto-generated method stub
		this.transactionStatus=successful;
	}

	public void setWallet(Wallet wallet2) {
		// TODO Auto-generated method stub
		this.wallet=wallet2;
	}
	
	public static Builder builder() {
		// TODO Auto-generated method stub
		return new Builder();
	}
	
	public static class Builder {
        private String txn_Id;
        private String fromUser;
        private String toUser;
        private double amount;
        private String timestamp;
        private TransactionStatus transactionStatus;
        private String createdOn;

        public Builder txn_Id(String txn_Id) {
            this.txn_Id = txn_Id;
            return this;
        }

        public Builder fromUser(String fromUser) {
            this.fromUser = fromUser;
            return this;
        }

        public Builder toUser(String toUser) {
            this.toUser = toUser;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder transactionStatus(TransactionStatus transactionStatus) {
            this.transactionStatus = transactionStatus;
            return this;
        }

        public Builder createdOn(String date) {
            this.createdOn = date;
            return this;
        }

        public Transaction build() {
            Transaction transaction = new Transaction();
            transaction.txn_Id = this.txn_Id;
            transaction.fromUser = this.fromUser;
            transaction.toUser = this.toUser;
            transaction.amount = this.amount;
            transaction.timestamp = this.timestamp;
            transaction.transactionStatus = this.transactionStatus;
            transaction.createdOn = this.createdOn;
            return transaction;
        }
    }
}
