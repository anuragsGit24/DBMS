package net.anurag.banking.service;

import net.anurag.banking.dto.LoanDTO;

import java.util.List;

public interface LoanService {
    List<LoanDTO> getAllLoans();
    LoanDTO getLoanById(Long id);
    LoanDTO createLoan(LoanDTO loanDTO);
    void deleteLoan(Long id);
}

