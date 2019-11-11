package vnuk.cse.scbanking.entity;

import lombok.Data;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;
import vnuk.cse.scbanking.entity.CardTypeAbstract.CardMaster;
import vnuk.cse.scbanking.entity.CardTypeAbstract.CardPaypal;
import vnuk.cse.scbanking.entity.CardTypeAbstract.CardVisa;
import vnuk.cse.scbanking.entity.WalletType.BillingWallet;
import vnuk.cse.scbanking.entity.WalletType.ShoppingWallet;

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
                   Double amount, CommonPayment commonPayment, User user, Bill bill)
    {
        this.consumerNumber = consumerNumber;
        this.billNumber = billNumber;
        this.amount = amount;
        this.commonPayment = commonPayment;
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

    @Any(metaColumn = @Column(name = "payment_type"))
    @AnyMetaDef(idType = "integer", metaType = "string", metaValues = {
            @MetaValue(targetEntity = Card.class, value = "Card"),
            @MetaValue(targetEntity = CardMaster.class, value = "Card Master"),
            @MetaValue(targetEntity = CardPaypal.class, value = "Card Paypal"),
            @MetaValue(targetEntity = CardVisa.class, value = "Card Visa"),
            @MetaValue(targetEntity = Wallet.class, value = "Wallet"),
            @MetaValue(targetEntity = BillingWallet.class, value = "Billing Wallet"),
            @MetaValue(targetEntity = ShoppingWallet.class, value = "Shopping Wallet")
    })
    @Cascade( { org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "payment_row_id")
    protected CommonPayment commonPayment;


    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    protected Bill bill;

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
