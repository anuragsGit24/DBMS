package net.anurag.banking.mapper;

import net.anurag.banking.dto.LoanDTO;
import net.anurag.banking.entity.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanDTO toDto(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setLoanId(loan.getLoanId());
        dto.setLoanAmount(loan.getLoanAmount());
        dto.setInterestRate(loan.getInterestRate());
        dto.setLoanType(loan.getLoanType());
        dto.setAccountId(loan.getAccount().getId());
        return dto;
    }

    public Loan toEntity(LoanDTO dto) {
        Loan loan = new Loan();
        loan.setLoanAmount(dto.getLoanAmount());
        loan.setInterestRate(dto.getInterestRate());
        loan.setLoanType(dto.getLoanType());
        return loan;
    }
}
