package net.anurag.banking.entity;

import jakarta.persistence.*;


@Entity
public class UPITransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int upiTransactionId;

    @Column(nullable = false, length = 50)
    private String upiId;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "transactionId", nullable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    @Column(nullable = false, length = 10)
    private String transactionType; // "Deposit" or "Withdraw"

    // Getters and Setters
    public int getUpiTransactionId() {
        return upiTransactionId;
    }

    public void setUpiTransactionId(int upiTransactionId) {
        this.upiTransactionId = upiTransactionId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}


