package vnuk.cse.scbanking.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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


    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private int walletId;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private int billId;

    @Column(name = "created_at")
    private String createdAt;

}
