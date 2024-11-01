package net.anurag.banking.service.impl;

import net.anurag.banking.dto.EmployeeDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.Employee;
import net.anurag.banking.mapper.EmployeeMapper;
import net.anurag.banking.repository.AccountRepository;
import net.anurag.banking.repository.EmployeeRepository;
import net.anurag.banking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDto)
                .orElse(null);
    }

    @Transactional
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Account account = accountRepository.findById(employeeDTO.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        employee.setAccount(account);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Transactional
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

