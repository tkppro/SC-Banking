package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
        List<Card> findAll();
        List<Card> findCardByCardNumber(String cardNumber);
}
