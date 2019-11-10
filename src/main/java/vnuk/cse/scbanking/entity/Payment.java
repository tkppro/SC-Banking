package vnuk.cse.scbanking.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="payments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="PD")
public class Payment implements Serializable, CommonTransaction{

    public Payment()
    {}

    public Payment(String consumerNumber, String billNumber,
                   Double amount, Wallet wallet, User user, Bill bill)
    {
        this.consumerNumber = consumerNumber;
        this.billNumber = billNumber;
        this.amount = amount;
        this.wallet = wallet;
        this.user = user;
        this.bill = bill;
        this.createdAt = new Date();
    }
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected int id;

    @NotNull(message = "Consumer number cannot be empty")
    @Column(name = "consumer_number")
    protected String consumerNumber;

    @NotNull(message = "Bill number cannot be empty")
    @Column(name = "bill_number")
    protected String billNumber;

    @Column(name = "amount")
    protected double amount;

    @Column(name = "discriminator", nullable = true, insertable = false, updatable = false)
    protected String discriminator;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    protected Date createdAt;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    protected Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    protected Bill bill;

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

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    @Override
    public Double getAmount() {
        return this.amount;
    }

    @Override
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public String getTransactionName() {
        return this.bill.getName();
    }
}
