package vnuk.cse.scbanking.pattern.cardabstractfactory;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;

import java.util.Date;

public interface CardAbstractFactory {
    Card createCard(String cardNumber, int cvv, User user, CardType cardType, String expiredDay);
}
