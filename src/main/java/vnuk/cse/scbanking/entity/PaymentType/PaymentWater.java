package vnuk.cse.scbanking.entity.PaymentType;

import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.entity.Payment;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("PW")
@Table(name="payments")
public class PaymentWater extends Payment implements Serializable {
    public PaymentWater(){}

    public PaymentWater(String consumerNumber, String billNumber,
                        Double amount, Wallet wallet, User user, Bill bill)
    {
        super(consumerNumber, billNumber, amount, wallet, user, bill);
    }
}