package vnuk.cse.scbanking.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Topups")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="TU")
public class TopUp {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected int id;
    @Column(name = "amount")
    protected double amount = 0.0;

    public TopUp() {
    }

    public TopUp(Card card, User user, Wallet wallet, double amount) {
        this.card = card;
        this.user = user;
        this.wallet = wallet;
        this.amount = amount;
        this.createdAt = new Date();
    }

    @Column(name = "created_at")
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

}
