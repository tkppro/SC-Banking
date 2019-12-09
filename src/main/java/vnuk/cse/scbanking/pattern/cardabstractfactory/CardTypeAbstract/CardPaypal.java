package vnuk.cse.scbanking.pattern.cardabstractfactory.CardTypeAbstract;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
@DiscriminatorValue(value="CP")
public class CardPaypal extends Card {
    public CardPaypal() {
    }

    public CardPaypal(String cardNumber, int cvv, User user, CardType cardType, String expiredDay, String bussinessClass) {
        super(cardNumber, cvv, user, cardType, expiredDay, bussinessClass);
    }
}
