package net.anurag.banking.mapper;

import net.anurag.banking.dto.AccountDTO;
import net.anurag.banking.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    // Convert from Entity to DTO
    public AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }

        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setAccountHolderName(account.getAccountHolderName());
        dto.setBalance(account.getBalance());
        return dto;
    }

    // Convert from DTO to Entity
    public Account toEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setAccountHolderName(accountDTO.getAccountHolderName());
        account.setBalance(accountDTO.getBalance());
        return account;
    }
}
