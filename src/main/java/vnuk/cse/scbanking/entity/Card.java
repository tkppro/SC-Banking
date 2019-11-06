package vnuk.cse.scbanking.entity;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import vnuk.cse.scbanking.entity.User;

@Data
@Entity
@Table(name="cards")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="CD")

public class Card implements Serializable{

    public Card() {
    }

    public Card(String cardNumber, int cvv, User user, CardType cardType, String expiredDay) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.user = user;
        this.cardType = cardType;
        this.expiredDate = expiredDay;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "expired_date")
    private String expiredDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_type_id")
    private CardType cardType;

    @OneToMany(mappedBy = "card")
    private List<TopUp> topUp;
}
