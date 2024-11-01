package net.anurag.banking.repository;

import net.anurag.banking.entity.UPITransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UPITransactionRepository extends JpaRepository<UPITransaction, Integer> {
}
