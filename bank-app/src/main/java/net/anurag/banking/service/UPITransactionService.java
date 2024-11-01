package net.anurag.banking.service;

import net.anurag.banking.dto.UPITransactionDTO;

import java.util.List;

public interface UPITransactionService {
    UPITransactionDTO createUPITransaction(UPITransactionDTO upiTransactionDTO);
    List<UPITransactionDTO> getAllUPITransactions();
    UPITransactionDTO getUPITransactionById(Integer id);
    void deleteUPITransactionById(Integer id);
}


