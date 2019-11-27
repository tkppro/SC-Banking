package vnuk.cse.scbanking.pattern.cardabstractfactory.CardTypeAbstract;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
@DiscriminatorValue(value="CM")
public class CardMaster extends Card {
    public CardMaster() {
    }

    public CardMaster(String cardNumber, int cvv, User user, CardType cardType, String expiredDay, String bussinessClass) {
        super(cardNumber, cvv, user, cardType, expiredDay, bussinessClass);
    }

}
