package net.anurag.banking.service.impl;

import net.anurag.banking.dto.AccountDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.mapper.AccountMapper;
import net.anurag.banking.repository.AccountRepository;
import net.anurag.banking.service.AccountService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(accountMapper::toDTO)
                .toList();
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        return accountMapper.toDTO(accountRepository.findById(id).orElse(null));
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        return accountMapper.toDTO(accountRepository.save(account));
    }

    @Override
    public boolean deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

