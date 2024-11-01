package net.anurag.banking.service.impl;

import net.anurag.banking.dto.TransactionDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.Transaction;
import net.anurag.banking.mapper.TransactionMapper;
import net.anurag.banking.repository.AccountRepository;
import net.anurag.banking.repository.TransactionRepository;
import net.anurag.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .map(transactionMapper::toDto)
                .orElse(null);
    }

    @Transactional
    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        try {
            Transaction transaction = transactionMapper.toEntity(transactionDTO);
            Account account = accountRepository.findById(transactionDTO.getAccountId())
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            double amount = transaction.getAmount();
            if ("Deposit".equalsIgnoreCase(transaction.getTransactionType())) {
                account.setBalance(account.getBalance() + amount);
            } else if ("Withdrawal".equalsIgnoreCase(transaction.getTransactionType())) {
                if (account.getBalance() < amount) {
                    throw new RuntimeException("Insufficient balance");
                }
                account.setBalance(account.getBalance() - amount);
            }

            accountRepository.save(account);
            Transaction savedTransaction = transactionRepository.save(transaction);
            return transactionMapper.toDto(savedTransaction);
        } catch (Exception e) {
            throw new RuntimeException("Error creating transaction: " + e.getMessage());
        }
    }

    @Transactional
    @Override
    public boolean deleteTransaction(Long id) {
        try {
            Transaction transaction = transactionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Transaction not found"));

            Account account = transaction.getAccount();
            if ("Deposit".equalsIgnoreCase(transaction.getTransactionType())) {
                account.setBalance(account.getBalance() - transaction.getAmount());
            } else if ("Withdrawal".equalsIgnoreCase(transaction.getTransactionType())) {
                account.setBalance(account.getBalance() + transaction.getAmount());
            }
            accountRepository.save(account);
            transactionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.err.println("Error deleting transaction: " + e.getMessage());
            return false;
        }
    }
}
