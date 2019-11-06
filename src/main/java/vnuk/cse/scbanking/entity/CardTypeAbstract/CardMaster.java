package vnuk.cse.scbanking.entity.CardTypeAbstract;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cards")
@DiscriminatorValue(value="CM")
public class CardMaster extends Card {
    public CardMaster() {
    }

    public CardMaster(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        super(cardNumber, cvv, user, cardType, expiredDay);
    }

}
