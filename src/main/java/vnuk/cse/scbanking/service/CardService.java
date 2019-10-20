package vnuk.cse.scbanking.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.repositories.CardRepository;

import java.util.List;

@Service

public class CardService {
    @Autowired
    CardRepository cardRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }
    public List<Card> findCardByCard_number(String cardNumber) {return  cardRepository.findCardByCard_number(cardNumber);}
}
