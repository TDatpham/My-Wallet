package online.digital.wallet.eWallet.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.digital.wallet.eWallet.Model.Transaction;
import online.digital.wallet.eWallet.Model.TransactionStatus;
import online.digital.wallet.eWallet.Model.Wallet;
import online.digital.wallet.eWallet.Repository.TransactionRepository;
import online.digital.wallet.eWallet.Repository.UserRepository;
import online.digital.wallet.eWallet.Repository.WalletRepository;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    WalletService walletService;

    public Transaction initiateTransaction(String fromUser, String toUser, double bigDecimal) {
        Transaction transaction = Transaction.builder()
                                .txn_Id(UUID.randomUUID().toString())
                                .fromUser(fromUser)
                                .toUser(toUser)
                                .amount(bigDecimal)
                                .transactionStatus(TransactionStatus.PENDING)
                                .createdOn( new Date().toString()).build();
        
        transactionRepository.save(transaction);

        // UPDATE BALANCE
        Wallet senderWallet = walletService.getWalletByOwner(fromUser);
        
        if(senderWallet.getBalance() >= 0) {
            // DEDUCT MONEY FROM SENDER WALLET
            Wallet receiverWallet = walletService.getWalletByOwner(toUser);
            
            walletService.updateBalance(senderWallet, -1*bigDecimal);
            walletService.updateBalance(receiverWallet, bigDecimal);

            transaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);
            transactionRepository.save(transaction);

            // add received txn to wallet
            updateTxnList(receiverWallet, transaction);
        } 
        else { 
            // low balance -> TRANSACTION FAILED
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
        }

        // add send txn to wallet
        updateTxnList(senderWallet, transaction);

        return transaction;
    }

    private void updateTxnList(Wallet wallet, Transaction transaction) {
        wallet.getTransactions().add(transaction);
        transaction.setWallet(wallet);
        transactionRepository.save(transaction);
    }


    public List<Transaction> getTransactionsByWallet(Wallet wallet) {
        return transactionRepository.findAllByWallet(wallet);
    }


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

}
