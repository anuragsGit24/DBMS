package net.anurag.banking.service;

import net.anurag.banking.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getAllAccounts();
    AccountDTO getAccountById(Long id);
    AccountDTO createAccount(AccountDTO accountDTO);

    boolean deleteAccount(Long id);
}
