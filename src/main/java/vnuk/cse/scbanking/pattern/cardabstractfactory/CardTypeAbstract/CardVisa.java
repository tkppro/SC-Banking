package vnuk.cse.scbanking.pattern.cardabstractfactory.CardTypeAbstract;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@DiscriminatorValue(value="CV")
public class CardVisa extends Card {
    public CardVisa() {
    }
    public CardVisa(String cardNumber, int cvv, User user, CardType cardType, String expiredDay, String bussinessClass) {
        super(cardNumber, cvv, user, cardType, expiredDay, bussinessClass);
    }
}
