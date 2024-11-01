package net.anurag.banking.controller;

import net.anurag.banking.dto.FixedDepositDTO;
import net.anurag.banking.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fixed-deposits")
public class FixedDepositController {

    @Autowired
    private FixedDepositService fixedDepositService;

    @GetMapping
    public List<FixedDepositDTO> getAllFixedDeposits() {
        return fixedDepositService.getAllFixedDeposits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FixedDepositDTO> getFixedDepositById(@PathVariable Long id) {
        FixedDepositDTO fixedDeposit = fixedDepositService.getFixedDepositById(id);
        return fixedDeposit != null ? ResponseEntity.ok(fixedDeposit) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FixedDepositDTO> createFixedDeposit(@RequestBody FixedDepositDTO fixedDepositDTO) {
        FixedDepositDTO createdFixedDeposit = fixedDepositService.createFixedDeposit(fixedDepositDTO);
        return ResponseEntity.status(201).body(createdFixedDeposit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFixedDeposit(@PathVariable Long id) {
        fixedDepositService.deleteFixedDeposit(id);
        return ResponseEntity.noContent().build();
    }
}

