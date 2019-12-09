package vnuk.cse.scbanking.pattern.cardabstractfactory;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.pattern.cardabstractfactory.CardTypeAbstract.CardVisa;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.pattern.cardabstractfactory.bussinessclass.BussinessClass;
import vnuk.cse.scbanking.pattern.cardabstractfactory.bussinessclass.CardVisaBussinessClass;

public class CardVisaFactory implements CardAbstractFactory{
    @Override
    public BussinessClass callClass() {
        return new CardVisaBussinessClass();
    }

    @Override
    public Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        String myBussinessClass = this.callClass().showClass();
        return new CardVisa(cardNumber, cvv, user, cardType, expiredDay, myBussinessClass);
    }
}
