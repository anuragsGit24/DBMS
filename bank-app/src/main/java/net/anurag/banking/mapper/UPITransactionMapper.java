package net.anurag.banking.mapper;

import net.anurag.banking.dto.UPITransactionDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.UPITransaction;
import net.anurag.banking.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class UPITransactionMapper {

    public UPITransaction toEntity(UPITransactionDTO dto, Transaction transaction, Account account) {
        UPITransaction upiTransaction = new UPITransaction();
        upiTransaction.setUpiTransactionId(dto.getUpiTransactionId());
        upiTransaction.setUpiId(dto.getUpiId());
        upiTransaction.setAmount(dto.getAmount());
        upiTransaction.setTransaction(transaction);
        upiTransaction.setAccount(account);
        upiTransaction.setTransactionType(dto.getTransactionType());
        return upiTransaction;
    }

    public UPITransactionDTO toDTO(UPITransaction entity) {
        UPITransactionDTO dto = new UPITransactionDTO();
        dto.setUpiTransactionId(entity.getUpiTransactionId());
        dto.setUpiId(entity.getUpiId());
        dto.setAmount(entity.getAmount());
        dto.setTransactionId(entity.getTransaction().getTransactionId());
        dto.setAccountId(entity.getAccount().getId());
        dto.setTransactionType(entity.getTransactionType());
        return dto;
    }
}

