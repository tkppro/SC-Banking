package vnuk.cse.scbanking.entity;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import vnuk.cse.scbanking.entity.User;

@Data
@Entity
@Table(name="cards")
public class Card implements Serializable{
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "expired_date")
    private String expiredDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "card_type_id")
    private CardType cardType;
}
