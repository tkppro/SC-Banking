package vnuk.cse.scbanking.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="wallets")
public class Wallet implements Serializable {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "created_at")
    public String createdAt;

    @Column(name = "amount")
    public String amount;
}
