package net.anurag.banking.service;

import net.anurag.banking.dto.CardPaymentDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardPaymentService {
    List<CardPaymentDTO> getAllCardPayments();
    CardPaymentDTO getCardPaymentById(Long id);
    CardPaymentDTO createCardPayment(CardPaymentDTO cardPaymentDTO) throws Exception;

    @Transactional
    CardPaymentDTO updateCardPayment(Long paymentId, CardPaymentDTO cardPaymentDTO) throws Exception;

    void deleteCardPayment(Long id) throws Exception;
}

