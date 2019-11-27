package vnuk.cse.scbanking.pattern.cardabstractfactory;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.pattern.cardabstractfactory.CardTypeAbstract.CardMaster;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.pattern.cardabstractfactory.bussinessclass.BussinessClass;
import vnuk.cse.scbanking.pattern.cardabstractfactory.bussinessclass.CardMasterBussinessClass;

public class CardMasterFactory implements  CardAbstractFactory{

    @Override
    public BussinessClass callClass() {
        return new CardMasterBussinessClass();
    }

    @Override
    public Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        String myBussinessClass = this.callClass().showClass();
        CardMaster cardMaster = new CardMaster(cardNumber, cvv, user, cardType, expiredDay, myBussinessClass);
        return cardMaster;
    }
}
