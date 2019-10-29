package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.Payment;
import vnuk.cse.scbanking.entity.PaymentType.BillType;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentCapleFactory;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentElectricityFactory;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentFactory;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentWaterFactory;
import vnuk.cse.scbanking.repositories.BillRepository;
import vnuk.cse.scbanking.repositories.PaymentRepository;
import vnuk.cse.scbanking.repositories.UserRepository;
import vnuk.cse.scbanking.repositories.WalletRepository;

import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    BillRepository billRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WalletRepository walletRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public PaymentFactory paymentFactory(int billId)
    {
        switch (billId){
            case BillType.BILL_ELECTRICITY:
                return new PaymentElectricityFactory();
            case BillType.BILL_CAPLE:
                return new PaymentCapleFactory();
            case BillType.BILL_WATER:
                return new PaymentWaterFactory();
            default:
                return null;
        }
    }

    public boolean payment(Map<String, String> data)
    {
        Wallet wallet = this.walletRepository.findWalletById(Integer.parseInt(data.get("wallet_id")));
        if(wallet == null || wallet.getAmount() < Double.parseDouble(data.get("amount")) || data.get("amount") == null)
        {
            return false;
        }

        wallet.setAmount(wallet.getAmount() - Double.parseDouble(data.get("amount")));
        this.walletRepository.save(wallet);

        PaymentFactory factory = paymentFactory(Integer.parseInt(data.get("bill_id")));
        Payment payment = factory.createPayment(data.get("consumerNumber"), data.get("billNumber"),
                Double.parseDouble(data.get("amount")),
                wallet,this.userRepository.findUserById(Integer.parseInt(data.get("user_id"))),
                this.billRepository.findBillById(Integer.parseInt(data.get("bill_id"))));

        paymentRepository.save(payment);

        return true;
    }


}
