package vnuk.cse.scbanking.entity.PaymentType;

import vnuk.cse.scbanking.entity.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("PW")
@Table(name="payments")
public class PaymentWater extends Payment implements Serializable {
    public PaymentWater(){}

    public PaymentWater(String consumerNumber, String billNumber,
                        Double amount, CommonPayment commonPayment, User user, Bill bill)
    {
        super(consumerNumber, billNumber, amount, commonPayment, user, bill);
    }
}
