package net.anurag.banking.mapper;

import net.anurag.banking.dto.FixedDepositDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.Employee;
import net.anurag.banking.entity.FixedDeposit;
import org.springframework.stereotype.Component;

@Component
public class FixedDepositMapper {

    public FixedDepositDTO toDTO(FixedDeposit fixedDeposit) {
        if (fixedDeposit == null) {
            return null;
        }

        FixedDepositDTO dto = new FixedDepositDTO();
        dto.setFixedDepositId(fixedDeposit.getFixedDepositId());
        dto.setAccountId(fixedDeposit.getAccount() != null ? fixedDeposit.getAccount().getId() : null);
        dto.setEmployeeId(fixedDeposit.getEmployee() != null ? fixedDeposit.getEmployee().getId() : null);
        dto.setAmount(fixedDeposit.getAmount());
        dto.setInterestRate(fixedDeposit.getInterestRate());
        dto.setMaturityDate(fixedDeposit.getMaturityDate());

        return dto;
    }

    public FixedDeposit toEntity(FixedDepositDTO fixedDepositDTO, Account account, Employee employee) {
        if (fixedDepositDTO == null) {
            return null;
        }

        FixedDeposit fixedDeposit = new FixedDeposit();
        fixedDeposit.setFixedDepositId(fixedDepositDTO.getFixedDepositId());
        fixedDeposit.setAccount(account);
        fixedDeposit.setEmployee(employee);
        fixedDeposit.setAmount(fixedDepositDTO.getAmount());
        fixedDeposit.setInterestRate(fixedDepositDTO.getInterestRate());
        fixedDeposit.setMaturityDate(fixedDepositDTO.getMaturityDate());

        return fixedDeposit;
    }
}
