package vnuk.cse.scbanking.pattern.paymentstrategy;


import vnuk.cse.scbanking.entity.*;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentFactory;

import java.util.Map;

public interface PaymentStrategy {
    Payment pay(Map<String, String> data, PaymentFactory paymentFactory, User user,
                Bill bill);
}
