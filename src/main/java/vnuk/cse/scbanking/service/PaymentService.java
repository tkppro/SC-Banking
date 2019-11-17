package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.*;
import vnuk.cse.scbanking.entity.PaymentType.BillType;
import vnuk.cse.scbanking.entity.Transaction;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentCableFactory;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentElectricityFactory;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentFactory;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentWaterFactory;
import vnuk.cse.scbanking.pattern.paymentstrategy.PaymentContext;
import vnuk.cse.scbanking.repositories.*;

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

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public PaymentFactory paymentFactory(int billId)
    {
        switch (billId){
            case BillType.BILL_ELECTRICITY:
                return new PaymentElectricityFactory();
            case BillType.BILL_CAPLE:
                return new PaymentCableFactory();
            case BillType.BILL_WATER:
                return new PaymentWaterFactory();
            default:
                return null;
        }
    }

    public boolean payment(Map<String, String> data, PaymentContext paymentContext)
    {
        if(data.get("wallet_id") != null)
        {
            Wallet wallet = this.walletRepository.findWalletById(Integer.parseInt(data.get("wallet_id")));
            if(wallet == null || wallet.getAmount() < Double.parseDouble(data.get("amount")) || data.get("amount") == null)
            {
                return false;
            }
        }

        PaymentFactory factory = paymentFactory(Integer.parseInt(data.get("bill_id")));
        User user = this.userRepository.findUserById(Integer.parseInt(data.get("user_id")));
        Bill bill = this.billRepository.findBillById(Integer.parseInt(data.get("bill_id")));
        Payment payment = paymentContext.pay(data, factory, user, bill);

        paymentRepository.save(payment);
        Transaction transaction = new Transaction(Double.parseDouble(data.get("amount")), payment);
        transactionRepository.save(transaction);
        return true;
    }


}
