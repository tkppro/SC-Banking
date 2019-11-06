package vnuk.cse.scbanking.entity.CardTypeAbstract;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cards")
@DiscriminatorValue(value="CV")
public class CardVisa extends Card {
    public CardVisa() {
    }
    public CardVisa(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        super(cardNumber, cvv, user, cardType, expiredDay);
    }
}
