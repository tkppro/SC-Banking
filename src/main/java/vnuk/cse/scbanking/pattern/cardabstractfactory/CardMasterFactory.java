package vnuk.cse.scbanking.pattern.cardabstractfactory;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.CardTypeAbstract.CardMaster;
import vnuk.cse.scbanking.entity.User;

public class CardMasterFactory implements  CardAbstractFactory{

    @Override
    public Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        CardMaster cardMaster = new CardMaster(cardNumber, cvv, user, cardType, expiredDay);
        return cardMaster;
    }
}
