package net.anurag.banking.service;

import net.anurag.banking.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactions();
    TransactionDTO getTransactionById(Long id);
    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    boolean deleteTransaction(Long id);  // New delete method
}

