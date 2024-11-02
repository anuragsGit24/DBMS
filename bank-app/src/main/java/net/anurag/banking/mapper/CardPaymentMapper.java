package net.anurag.banking.mapper;

import net.anurag.banking.dto.CardPaymentDTO;
import net.anurag.banking.entity.Account;
import net.anurag.banking.entity.CardPayment;
import net.anurag.banking.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class CardPaymentMapper{
    public CardPayment toEntity(CardPaymentDTO dto, Account account) {
        if(dto == null)
        {
            return null;
        }
        CardPayment cardPayment = new CardPayment();
        cardPayment.setPaymentId(dto.getPaymentId());
        cardPayment.setAmount(dto.getAmount());
        cardPayment.setCardNumber(dto.getCardNumber());
        cardPayment.setTransactionType(dto.getTransactionType());
        cardPayment.setAccount(account); // Set the account
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
        dto.setTransactionType(cardPayment.getTransactionType());
        dto.setAccountId(cardPayment.getAccount().getId()); // Ensure you get the account ID
        return dto;
    }
}


