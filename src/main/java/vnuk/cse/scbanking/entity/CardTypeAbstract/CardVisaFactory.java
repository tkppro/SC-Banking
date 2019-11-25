package vnuk.cse.scbanking.entity.CardTypeAbstract;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;

import java.util.Date;

public class CardVisaFactory implements CardAbstractFactory{
    @Override
    public Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        return new CardVisa(cardNumber, cvv, user, cardType, expiredDay);
    }
}