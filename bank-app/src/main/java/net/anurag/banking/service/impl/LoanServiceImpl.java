package net.anurag.banking.service.impl;

import net.anurag.banking.dto.LoanDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.Loan;
import net.anurag.banking.mapper.LoanMapper;
import net.anurag.banking.repository.AccountRepository;
import net.anurag.banking.repository.LoanRepository;
import net.anurag.banking.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private LoanMapper loanMapper;

    @Override
    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(loanMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LoanDTO getLoanById(Long id) {
        return loanRepository.findById(id)
                .map(loanMapper::toDto)
                .orElse(null);
    }

    @Transactional
    @Override
    public LoanDTO createLoan(LoanDTO loanDTO) {
        Loan loan = loanMapper.toEntity(loanDTO);
        Account account = accountRepository.findById(loanDTO.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        loan.setAccount(account);
        return loanMapper.toDto(loanRepository.save(loan));
    }

    @Transactional
    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}

