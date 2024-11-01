package net.anurag.banking.controller;

import net.anurag.banking.dto.UPITransactionDTO;
import net.anurag.banking.service.UPITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/upi-transactions")
public class UPITransactionController {

    @Autowired
    private UPITransactionService upiTransactionService;

    // Create a new UPI Transaction
    @PostMapping
    public ResponseEntity<UPITransactionDTO> createUPITransaction(@RequestBody UPITransactionDTO upiTransactionDTO) {
        UPITransactionDTO createdUPITransaction = upiTransactionService.createUPITransaction(upiTransactionDTO);
        return ResponseEntity.ok(createdUPITransaction);
    }

    // Get all UPI Transactions
    @GetMapping
    public ResponseEntity<List<UPITransactionDTO>> getAllUPITransactions() {
        List<UPITransactionDTO> upiTransactions = upiTransactionService.getAllUPITransactions();
        return ResponseEntity.ok(upiTransactions);
    }

    // Get a UPI Transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<UPITransactionDTO> getUPITransactionById(@PathVariable Integer id) {
        UPITransactionDTO upiTransaction = upiTransactionService.getUPITransactionById(id);
        return ResponseEntity.ok(upiTransaction);
    }

    // Delete a UPI Transaction by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUPITransactionById(@PathVariable Integer id) {
        upiTransactionService.deleteUPITransactionById(id);
        return ResponseEntity.noContent().build();
    }
}

