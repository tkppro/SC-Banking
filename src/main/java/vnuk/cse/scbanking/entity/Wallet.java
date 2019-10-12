package vnuk.cse.scbanking.entity;
import lombok.Data;

//import vnuk.cse.scbanking.entity.Card;
import javax.persistence.*;
import java.io.Serializable;

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

//    @ManyToOne
//    @JoinColumn(name="card_id", nullable=false)
//    private Card card;
}
