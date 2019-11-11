package vnuk.cse.scbanking.pattern.paymentfactory;

import vnuk.cse.scbanking.entity.*;

public abstract class PaymentFactory {
    public abstract Payment createPayment(String consumerNumber, String billNumber, Double amount, CommonPayment commonPayment,
                                          User user, Bill bill);
}
