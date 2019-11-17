package vnuk.cse.scbanking.pattern.paymentfactory;

import vnuk.cse.scbanking.entity.*;
import vnuk.cse.scbanking.entity.PaymentType.PaymentWater;

public class PaymentWaterFactory extends PaymentFactory {

    @Override
    public Payment createPayment(String consumerNumber, String billNumber, Double amount, CommonPayment commonPayment, User user,
                                 Bill bill)
    {
        return new PaymentWater(consumerNumber, billNumber, amount, commonPayment, user, bill);
    }
}
