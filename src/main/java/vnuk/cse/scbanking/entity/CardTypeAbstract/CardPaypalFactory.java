package vnuk.cse.scbanking.entity.CardTypeAbstract;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;

import java.util.Date;

public class CardPaypalFactory implements CardAbstractFactory{
    @Override
    public Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        CardPaypal cardPaypal = new CardPaypal(cardNumber, cvv, user, cardType, expiredDay);
        return cardPaypal;
    }
}
