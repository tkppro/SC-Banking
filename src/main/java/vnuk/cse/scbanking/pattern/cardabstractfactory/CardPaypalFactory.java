package vnuk.cse.scbanking.pattern.cardabstractfactory;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.pattern.cardabstractfactory.CardTypeAbstract.CardPaypal;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.pattern.cardabstractfactory.bussinessclass.BussinessClass;
import vnuk.cse.scbanking.pattern.cardabstractfactory.bussinessclass.CardPaypalBussinessClass;

public class CardPaypalFactory implements CardAbstractFactory{
    @Override
    public BussinessClass callClass() {
        return new CardPaypalBussinessClass();
    }

    @Override
    public Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        String myBussinessClass = this.callClass().showClass();
        CardPaypal cardPaypal = new CardPaypal(cardNumber, cvv, user, cardType, expiredDay, myBussinessClass);
        return cardPaypal;
    }
}
