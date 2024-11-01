package net.anurag.banking.service;

import net.anurag.banking.dto.FixedDepositDTO;

import java.util.List;

public interface FixedDepositService {

    List<FixedDepositDTO> getAllFixedDeposits();

    FixedDepositDTO getFixedDepositById(Long id);

    FixedDepositDTO createFixedDeposit(FixedDepositDTO fixedDepositDTO);

    void deleteFixedDeposit(Long id);
}

