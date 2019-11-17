package vnuk.cse.scbanking.entity.PaymentType;

import vnuk.cse.scbanking.entity.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@DiscriminatorValue("PC")
@Table(name="payments")
public class PaymentCable extends Payment implements Serializable {
    public PaymentCable(){}

    public PaymentCable(String consumerNumber, String billNumber,
                        Double amount, CommonPayment commonPayment, User user, Bill bill)
    {
        super(consumerNumber, billNumber, amount, commonPayment, user, bill);
    }
}
