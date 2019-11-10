package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
