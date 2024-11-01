package net.anurag.banking.service.impl;

import net.anurag.banking.dto.UPITransactionDTO;
import net.anurag.banking.entity.UPITransaction;
import net.anurag.banking.entity.Transaction;
import net.anurag.banking.entity.Account;
import net.anurag.banking.mapper.UPITransactionMapper;
import net.anurag.banking.repository.UPITransactionRepository;
import net.anurag.banking.repository.TransactionRepository;
import net.anurag.banking.repository.AccountRepository;
import net.anurag.banking.service.UPITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UPITransactionServiceImpl implements UPITransactionService {

    @Autowired
    private UPITransactionRepository upiTransactionRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UPITransactionMapper upiTransactionMapper;

    @Override
    public UPITransactionDTO createUPITransaction(UPITransactionDTO upiTransactionDTO) {
        Transaction transaction = transactionRepository.findById(Long.valueOf(upiTransactionDTO.getTransactionId()))
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        Account account = transaction.getAccount();

        if (upiTransactionDTO.getTransactionType().equals("Deposit"))
            account.setBalance(account.getBalance() + upiTransactionDTO.getAmount());
        else if (upiTransactionDTO.getTransactionType().equals("Withdraw")) {
            account.setBalance(account.getBalance() - upiTransactionDTO.getAmount());
        }

        accountRepository.save(account);

        UPITransaction upiTransaction = upiTransactionMapper.toEntity(upiTransactionDTO, transaction, account);
        upiTransactionRepository.save(upiTransaction);
        return upiTransactionMapper.toDTO(upiTransaction);
    }
    @Override
    public List<UPITransactionDTO> getAllUPITransactions() {
        return upiTransactionRepository.findAll().stream()
                .map(upiTransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UPITransactionDTO getUPITransactionById(Integer id) {
        UPITransaction upiTransaction = upiTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UPITransaction not found"));
        return upiTransactionMapper.toDTO(upiTransaction);
    }

    @Override
    public void deleteUPITransactionById(Integer id) {
        UPITransaction upiTransaction = upiTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UPITransaction not found"));
        upiTransactionRepository.delete(upiTransaction);
    }
}

