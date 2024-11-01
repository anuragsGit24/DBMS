package net.anurag.banking.mapper;

import net.anurag.banking.dto.TransactionDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionDTO toDto(Transaction transaction) {
        if (transaction == null) return null;

        TransactionDTO dto = new TransactionDTO();
        dto.setTransactionId(transaction.getTransactionId());
        dto.setTransactionType(transaction.getTransactionType());
        dto.setAmount(transaction.getAmount());
        if (transaction.getAccount() != null) {
            dto.setAccountId(transaction.getAccount().getId());
        }
        return dto;
    }

    public Transaction toEntity(TransactionDTO dto) {
        if (dto == null) return null;

        Transaction transaction = new Transaction();
        transaction.setTransactionId(dto.getTransactionId());
        transaction.setTransactionType(dto.getTransactionType());
        transaction.setAmount(dto.getAmount());

        Account account = new Account();
        account.setId(dto.getAccountId());
        transaction.setAccount(account);

        return transaction;
    }
}

