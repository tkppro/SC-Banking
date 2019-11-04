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
import java.util.List;

@Data
@Entity
@Table(name="wallets")
public class Wallet implements Serializable {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Size(min = 2, max = 32, message = "Length should be in between 2 to 32 characters!")
    @Pattern(regexp="^[a-zA-Z0-9\\s]+$",message = "Special characters are not allow!")
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "amount")
    private double amount = 0.0;

    @OneToMany(mappedBy = "wallet")
    private List<Payment> payment;

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
