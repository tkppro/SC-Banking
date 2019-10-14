package vnuk.cse.scbanking.entity;
import lombok.Data;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.Payment;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="wallets")
public class Wallet implements Serializable {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "amount")
    private String amount;

    @OneToMany(mappedBy = "wallet")
    private List<Payment> payment;

    @ManyToOne
    @JoinColumn(name="card_id")
    private Card card;
}
