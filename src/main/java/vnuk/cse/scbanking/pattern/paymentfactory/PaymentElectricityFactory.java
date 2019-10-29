package vnuk.cse.scbanking.pattern.paymentfactory;

import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.entity.Payment;
import vnuk.cse.scbanking.entity.PaymentType.PaymentElectricity;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;

public class PaymentElectricityFactory extends PaymentFactory{

    @Override
    public Payment createPayment(String consumerNumber, String billNumber, Double amount, Wallet wallet, User user,
                                 Bill bill)
    {
        return new PaymentElectricity(consumerNumber, billNumber, amount, wallet, user, bill);
    }
}
