package vnuk.cse.scbanking.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.CardTypeAbstract.*;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.repositories.CardRepository;
import vnuk.cse.scbanking.repositories.CardTypeRepository;
import vnuk.cse.scbanking.repositories.UserRepository;

import java.util.Date;
import java.util.List;

@Service

public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CardTypeRepository cardTypeRepository;
    @Autowired
    UserRepository userRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }
    public List<Card> findCardByUserId(int id) {return cardRepository.findCardByUserId(id);}
    public Card findCardByCardNumber(String cardNumber) {
        return cardRepository.findCardByCardNumber(cardNumber);
    }
    public Card findCardById(int id) {return cardRepository.findById(id);}

    public CardAbstractFactory cardAbstractFactory (int cardId)
    {
        switch (cardId){
            case CardTypeId.CARD_VISA:
                return new CardVisaFactory();
            case CardTypeId.CARD_PAYPAL:
                return new CardPaypalFactory();
            case CardTypeId.CARD_MASTER:
                return new CardMasterFactory();
            default:
                return null;
        }

    }

    public boolean card(String cardNumber, int cardTypeId, int cvv, String expireDay)
    {
        Card card = this.cardRepository.findCardByCardNumber(cardNumber);
        User user = this.userRepository.findUserById(1);
        CardType cardType = this.cardTypeRepository.findById(cardTypeId);
        if(card != null)
        {
            return false;
        }

        CardAbstractFactory factory = cardAbstractFactory(cardTypeId);
        Card newcard = factory.createCard(cardNumber, cvv, user , cardType, expireDay );

        this.cardRepository.save(newcard);

        return true;
    }

    public Card findById(int id) {
        return this.cardRepository.findById(id);
    }
}
