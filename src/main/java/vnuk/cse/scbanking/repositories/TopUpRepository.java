package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.TopUp;

public interface TopUpRepository extends JpaRepository<TopUp, Integer> {
}
