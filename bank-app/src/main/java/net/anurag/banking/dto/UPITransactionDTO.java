package net.anurag.banking.dto;

import java.math.BigDecimal;

public class UPITransactionDTO {

    private int upiTransactionId;
    private String upiId;
    private Double amount;
    private Long transactionId;
    private Long accountId;
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

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}


