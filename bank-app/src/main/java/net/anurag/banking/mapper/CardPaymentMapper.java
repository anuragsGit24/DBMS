package net.anurag.banking.mapper;

import net.anurag.banking.dto.CardPaymentDTO;
import net.anurag.banking.entity.CardPayment;
import net.anurag.banking.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class CardPaymentMapper{
    public CardPayment toEntity(CardPaymentDTO dto, Transaction transaction) {
        if(dto == null)
        {
            return null;
        }
        CardPayment cardPayment = new CardPayment();
        cardPayment.setPaymentId(dto.getPaymentId());
        cardPayment.setAmount(dto.getAmount());
        cardPayment.setCardNumber(dto.getCardNumber());
        cardPayment.setTransaction(transaction); // Set the transaction
        return cardPayment;
    }

    public CardPaymentDTO toDTO(CardPayment cardPayment) {
        if(cardPayment == null)
        {
            return null;
        }
        CardPaymentDTO dto = new CardPaymentDTO();
        dto.setPaymentId(cardPayment.getPaymentId());
        dto.setAmount(cardPayment.getAmount());
        dto.setCardNumber(cardPayment.getCardNumber());
        dto.setTransactionId(cardPayment.getTransaction().getTransactionId()); // Ensure you get the transaction ID
        return dto;
    }
}


