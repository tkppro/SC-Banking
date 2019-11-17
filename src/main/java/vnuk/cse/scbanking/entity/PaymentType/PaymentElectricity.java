package vnuk.cse.scbanking.entity.PaymentType;

import vnuk.cse.scbanking.entity.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="payments")
@DiscriminatorValue("PE")
public class PaymentElectricity extends Payment implements Serializable {

    public PaymentElectricity(){}

    public PaymentElectricity(String consumerNumber, String billNumber,
                              Double amount, CommonPayment commonPayment, User user, Bill bill)
    {
        super(consumerNumber, billNumber, amount, commonPayment, user, bill);
    }
}
