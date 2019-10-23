package vnuk.cse.scbanking.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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

    @NotNull(message = "Consumer number cannot be empty")
    @Column(name = "consumer_number")
    private String consumerNumber;

    @NotNull(message = "Bill number cannot be empty")
    @Column(name = "bill_number")
    private String billNumber;

    @Column(name = "amount")
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setConsumerNumber(String consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
