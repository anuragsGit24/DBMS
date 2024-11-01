package net.anurag.banking.controller;

import net.anurag.banking.dto.CardPaymentDTO;
import net.anurag.banking.service.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card-payments")
public class CardPaymentController {

    @Autowired
    private CardPaymentService cardPaymentService;

    @GetMapping
    public List<CardPaymentDTO> getAllCardPayments() {
        return cardPaymentService.getAllCardPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardPaymentDTO> getCardPaymentById(@PathVariable Long id) {
        CardPaymentDTO cardPayment = cardPaymentService.getCardPaymentById(id);
        return cardPayment != null ? ResponseEntity.ok(cardPayment) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CardPaymentDTO> createCardPayment(@RequestBody CardPaymentDTO cardPaymentDTO) throws Exception {
        CardPaymentDTO createdCardPayment = cardPaymentService.createCardPayment(cardPaymentDTO);
        return ResponseEntity.status(201).body(createdCardPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardPayment(@PathVariable Long id) throws Exception {
        cardPaymentService.deleteCardPayment(id);
        return ResponseEntity.noContent().build();
    }
}

