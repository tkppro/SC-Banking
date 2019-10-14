package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findAll();
}
