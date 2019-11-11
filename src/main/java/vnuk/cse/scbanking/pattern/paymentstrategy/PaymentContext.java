package vnuk.cse.scbanking.pattern.paymentstrategy;

import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.*;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentFactory;

import java.util.Map;

@Service
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Payment pay(Map<String, String> data, PaymentFactory paymentFactory, User user, Bill bill)
    {
        return paymentStrategy.pay(data, paymentFactory, user, bill);
    }
}
