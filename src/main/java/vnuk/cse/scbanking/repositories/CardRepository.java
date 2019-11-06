package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
        List<Card> findAll();
        Card findCardByCardNumber(String cardNumber);
        List<Card> findCardByUserId(int userId);
        Card findById(int id);
}
