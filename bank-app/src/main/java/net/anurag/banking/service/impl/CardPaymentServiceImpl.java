package net.anurag.banking.service.impl;

import net.anurag.banking.dto.CardPaymentDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.CardPayment;
import net.anurag.banking.mapper.CardPaymentMapper;
import net.anurag.banking.repository.AccountRepository;
import net.anurag.banking.repository.CardPaymentRepository;
import net.anurag.banking.service.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardPaymentServiceImpl implements CardPaymentService {

    @Autowired
    private CardPaymentRepository cardPaymentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardPaymentMapper cardPaymentMapper;

    @Override
    public List<CardPaymentDTO> getAllCardPayments() {
        return cardPaymentRepository.findAll().stream()
                .map(cardPaymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CardPaymentDTO getCardPaymentById(Long paymentId) {
        CardPayment cardPayment = cardPaymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("CardPayment not found with ID: " + paymentId));
        return cardPaymentMapper.toDTO(cardPayment);
    }

    @Override
    @Transactional
    public CardPaymentDTO createCardPayment(CardPaymentDTO cardPaymentDTO) {
        // Fetch the account associated with the CardPayment
        Account account = accountRepository.findById(cardPaymentDTO.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + cardPaymentDTO.getAccountId()));

        // Update account balance based on transaction type
        if ("deposit".equalsIgnoreCase(cardPaymentDTO.getTransactionType())) {
            account.setBalance(account.getBalance() + cardPaymentDTO.getAmount());
        } else if ("withdraw".equalsIgnoreCase(cardPaymentDTO.getTransactionType())) {
            if (account.getBalance() < cardPaymentDTO.getAmount()) {
                throw new IllegalArgumentException("Insufficient balance for withdrawal");
            }
            account.setBalance(account.getBalance() - cardPaymentDTO.getAmount());
        } else {
            throw new IllegalArgumentException("Invalid transaction type. Must be 'deposit' or 'withdraw'.");
        }

        // Save the updated account balance
        accountRepository.save(account);

        // Create and save the CardPayment
        CardPayment cardPayment = cardPaymentMapper.toEntity(cardPaymentDTO, account);
        cardPaymentRepository.save(cardPayment);

        return cardPaymentMapper.toDTO(cardPayment);
    }

    @Override
    @Transactional
    public CardPaymentDTO updateCardPayment(Long paymentId, CardPaymentDTO cardPaymentDTO) {
        CardPayment existingCardPayment = cardPaymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("CardPayment not found with ID: " + paymentId));

        Account account = accountRepository.findById(cardPaymentDTO.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + cardPaymentDTO.getAccountId()));

        existingCardPayment.setAmount(cardPaymentDTO.getAmount());
        existingCardPayment.setCardNumber(cardPaymentDTO.getCardNumber());
        existingCardPayment.setTransactionType(cardPaymentDTO.getTransactionType());
        existingCardPayment.setAccount(account);

        cardPaymentRepository.save(existingCardPayment);

        return cardPaymentMapper.toDTO(existingCardPayment);
    }

    @Override
    @Transactional
    public void deleteCardPayment(Long paymentId) {
        CardPayment cardPayment = cardPaymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("CardPayment not found with ID: " + paymentId));

        cardPaymentRepository.delete(cardPayment);
    }
}
