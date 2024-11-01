package net.anurag.banking.service.impl;

import net.anurag.banking.dto.CardPaymentDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.CardPayment;
import net.anurag.banking.entity.Transaction;
import net.anurag.banking.mapper.CardPaymentMapper;
import net.anurag.banking.repository.AccountRepository;
import net.anurag.banking.repository.CardPaymentRepository;
import net.anurag.banking.repository.TransactionRepository;
import net.anurag.banking.service.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardPaymentServiceImpl implements CardPaymentService {

    @Autowired
    private CardPaymentRepository cardPaymentRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardPaymentMapper cardPaymentMapper;

    @Override
    public List<CardPaymentDTO> getAllCardPayments() {
        try {
            return cardPaymentRepository.findAll().stream()
                    .map(cardPaymentMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            // Log error or handle exception as needed
            throw new RuntimeException("Failed to fetch card payments: " + e.getMessage());
        }
    }

    @Override
    public CardPaymentDTO getCardPaymentById(Long paymentId) {
        try {
            CardPayment cardPayment = cardPaymentRepository.findById(paymentId)
                    .orElseThrow(() -> new Exception("CardPayment not found with ID: " + paymentId));
            return cardPaymentMapper.toDTO(cardPayment);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching CardPayment with ID " + paymentId + ": " + e.getMessage());
        }
    }

    @Override
    public CardPaymentDTO createCardPayment(CardPaymentDTO cardPaymentDTO) {
        try {
            Transaction transaction = transactionRepository.findById(cardPaymentDTO.getTransactionId())
                    .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));

            // Update account balance based on transaction type
            Account account = accountRepository.findById(transaction.getAccount().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Account not found"));

            if ("deposit".equalsIgnoreCase(transaction.getTransactionType())) {
                account.setBalance(account.getBalance() + cardPaymentDTO.getAmount());
            } else if ("withdrawal".equalsIgnoreCase(transaction.getTransactionType())) {
                if (account.getBalance() < cardPaymentDTO.getAmount()) {
                    throw new IllegalArgumentException("Insufficient balance");
                }
                account.setBalance(account.getBalance() - cardPaymentDTO.getAmount());
            }

            // Save updated account
            accountRepository.save(account);

            // Create CardPayment
            CardPayment cardPayment = cardPaymentMapper.toEntity(cardPaymentDTO, transaction);
            cardPaymentRepository.save(cardPayment);

            return cardPaymentMapper.toDTO(cardPayment);
        } catch (Exception e) {
            // Handle exception (log it, rethrow it, etc.)
            throw new RuntimeException("Error creating card payment", e);
        }
    }


    @Override
    @Transactional
    public CardPaymentDTO updateCardPayment(Long paymentId, CardPaymentDTO cardPaymentDTO) throws Exception {
        try {
            CardPayment existingCardPayment = cardPaymentRepository.findById(paymentId)
                    .orElseThrow(() -> new Exception("CardPayment not found with ID: " + paymentId));

            Transaction transaction = transactionRepository.findById(cardPaymentDTO.getTransactionId())
                    .orElseThrow(() -> new Exception("Transaction not found with ID: " + cardPaymentDTO.getTransactionId()));

            existingCardPayment.setAmount(cardPaymentDTO.getAmount());
            existingCardPayment.setCardNumber(cardPaymentDTO.getCardNumber());
            existingCardPayment.setTransaction(transaction);

            cardPaymentRepository.save(existingCardPayment);

            return cardPaymentMapper.toDTO(existingCardPayment);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void deleteCardPayment(Long paymentId) throws Exception {
        try {
            CardPayment cardPayment = cardPaymentRepository.findById(paymentId)
                    .orElseThrow(() -> new Exception("CardPayment not found with ID: " + paymentId));

            cardPaymentRepository.delete(cardPayment);
        } catch (Exception e) {
            throw e;
        }
    }
}
