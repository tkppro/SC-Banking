package vnuk.cse.scbanking.pattern.cardabstractfactory;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.pattern.cardabstractfactory.bussinessclass.BussinessClass;

import java.util.Date;

public interface CardAbstractFactory {
    BussinessClass callClass();
    Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay);
}
