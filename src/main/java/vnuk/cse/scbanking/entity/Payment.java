package vnuk.cse.scbanking.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;

@Data
@Entity
@Table(name="payments")
public class Payment implements Serializable{
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "consumer_number")
    private String consumerNumber;

    @Column(name = "bill_number")
    private String billNumber;

    @Column(name = "amount")
    private int amount;

    @Column(name = "created_at")
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
}
