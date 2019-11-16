package vnuk.cse.scbanking.entity;

import lombok.Data;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;
import vnuk.cse.scbanking.entity.PaymentType.PaymentCable;
import vnuk.cse.scbanking.entity.PaymentType.PaymentElectricity;
import vnuk.cse.scbanking.entity.PaymentType.PaymentWater;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="transactions")
public class Transaction implements Serializable {

    public Transaction(){}

    public Transaction(Double amount, CommonTransaction commonTransaction)
    {
        this.amount = amount;
        this.commonTransaction = commonTransaction;
        this.createdAt = new Date();
    }

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "created_at")
    private Date createdAt;

    @Any(metaColumn = @Column(name = "transaction_type"))
    @AnyMetaDef(idType = "integer", metaType = "string", metaValues = {
            @MetaValue(targetEntity = Payment.class, value = "Payment"),
            @MetaValue(targetEntity = PaymentWater.class, value = "Water"),
            @MetaValue(targetEntity = PaymentElectricity.class, value = "Electricity"),
            @MetaValue(targetEntity = PaymentCable.class, value = "Cable"),
            @MetaValue(targetEntity = TopUp.class, value = "Topup")
    })
    @Cascade( { org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "transaction_row_id")
    protected CommonTransaction commonTransaction;

}
