package net.anurag.banking.repository;

import net.anurag.banking.entity.CardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardPaymentRepository extends JpaRepository<CardPayment, Long> {
}

