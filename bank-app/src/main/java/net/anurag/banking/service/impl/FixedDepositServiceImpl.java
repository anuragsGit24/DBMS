package net.anurag.banking.service.impl;

import net.anurag.banking.dto.FixedDepositDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.Employee;
import net.anurag.banking.entity.FixedDeposit;
import net.anurag.banking.mapper.FixedDepositMapper;
import net.anurag.banking.repository.AccountRepository;
import net.anurag.banking.repository.EmployeeRepository;
import net.anurag.banking.repository.FixedDepositRepository;
import net.anurag.banking.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    private FixedDepositRepository fixedDepositRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private FixedDepositMapper fixedDepositMapper;

    @Override
    public List<FixedDepositDTO> getAllFixedDeposits() {
        return fixedDepositRepository.findAll()
                .stream()
                .map(fixedDepositMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FixedDepositDTO getFixedDepositById(Long id) {
        return fixedDepositRepository.findById(id)
                .map(fixedDepositMapper::toDTO)
                .orElse(null);
    }

    @Override
    public FixedDepositDTO createFixedDeposit(FixedDepositDTO fixedDepositDTO) {
        Account account = accountRepository.findById(fixedDepositDTO.getAccountId()).orElse(null);
        Employee employee = employeeRepository.findById(fixedDepositDTO.getEmployeeId()).orElse(null);

        if (account == null || employee == null) {
            throw new IllegalArgumentException("Invalid account or employee ID");
        }

        FixedDeposit fixedDeposit = fixedDepositMapper.toEntity(fixedDepositDTO, account, employee);
        fixedDeposit = fixedDepositRepository.save(fixedDeposit);

        return fixedDepositMapper.toDTO(fixedDeposit);
    }

    @Override
    public void deleteFixedDeposit(Long id) {
        fixedDepositRepository.deleteById(id);
    }
}

