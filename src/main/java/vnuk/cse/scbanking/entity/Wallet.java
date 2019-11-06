package vnuk.cse.scbanking.entity;
import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.Payment;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="wallets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="WD")
public class Wallet implements Serializable {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected int id;

    public Wallet() {}

    public Wallet(User user,String name, String description, String createdAt) {
        this.user = user;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    @Size(min = 2, max = 32, message = "Length should be in between 2 to 32 characters!")
    @Pattern(regexp="^[a-zA-Z0-9\\s]+$",message = "Special characters are not allow!")
    @Column(name = "name")
    protected String name;

    @Column(name = "description")
    protected String description;


    @Column(name = "created_at")
    protected String createdAt;

    @Column(name = "amount")
    protected double amount = 0.0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    @OneToMany(mappedBy = "wallet")
    protected List<Payment> payment;

    @OneToMany(mappedBy = "wallet")
    private List<TopUp> topUp;

    public double getAmount() {
        return this.amount;
    }

    public String getName() {
        return  this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
