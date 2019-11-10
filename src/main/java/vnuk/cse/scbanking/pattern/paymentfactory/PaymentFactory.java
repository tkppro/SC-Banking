package vnuk.cse.scbanking.pattern.paymentfactory;

import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.entity.Payment;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;

public abstract class PaymentFactory {
    public abstract Payment createPayment(String consumerNumber, String billNumber, Double amount, Wallet wallet,
                                          User user, Bill bill);
}
