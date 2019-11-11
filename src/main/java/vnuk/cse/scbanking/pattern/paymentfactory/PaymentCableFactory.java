package vnuk.cse.scbanking.pattern.paymentfactory;

import vnuk.cse.scbanking.entity.*;
import vnuk.cse.scbanking.entity.PaymentType.PaymentCable;

public class PaymentCableFactory extends PaymentFactory {
    @Override
    public Payment createPayment(String consumerNumber, String billNumber, Double amount, CommonPayment commonPayment, User user,
                                 Bill bill)
    {
        return new PaymentCable(consumerNumber, billNumber, amount, commonPayment, user, bill);
    }
}
