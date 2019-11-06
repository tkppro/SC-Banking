package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.CardType;

public interface CardTypeRepository extends JpaRepository<CardType, Integer> {
    CardType findById(int cardTypeid);
}
