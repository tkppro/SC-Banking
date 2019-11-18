package vnuk.cse.scbanking.pattern.cardabstractfactory;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.CardTypeAbstract.CardPaypal;
import vnuk.cse.scbanking.entity.User;

public class CardPaypalFactory implements CardAbstractFactory{
    @Override
    public Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        CardPaypal cardPaypal = new CardPaypal(cardNumber, cvv, user, cardType, expiredDay);
        return cardPaypal;
    }
}
