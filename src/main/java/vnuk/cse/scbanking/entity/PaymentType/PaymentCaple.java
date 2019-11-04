package vnuk.cse.scbanking.entity.PaymentType;

import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.entity.Payment;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@DiscriminatorValue("PC")
@Table(name="payments")
public class PaymentCaple extends Payment implements Serializable {
    public PaymentCaple(){}
    // Cable chứ ko phải là Caple nha man :v
    public PaymentCaple(String consumerNumber, String billNumber,
                              Double amount, Wallet wallet, User user, Bill bill)
    {
        super(consumerNumber, billNumber, amount, wallet, user, bill);
    }
}
