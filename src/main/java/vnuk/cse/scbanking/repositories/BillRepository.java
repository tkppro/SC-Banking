package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.Bill;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    List<Bill> findAll();

    Bill findBillById(int id);
}