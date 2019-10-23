package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.Payment;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.repositories.BillRepository;
import vnuk.cse.scbanking.repositories.PaymentRepository;
import vnuk.cse.scbanking.repositories.UserRepository;
import vnuk.cse.scbanking.repositories.WalletRepository;

import java.util.Date;
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

    public boolean payment(Map<String, String> data)
    {
        Wallet wallet = walletRepository.findWalletById(Integer.parseInt(data.get("wallet_id")));
        if(wallet == null || wallet.getAmount() < Double.parseDouble(data.get("amount")) || data.get("amount") == null)
        {
            return false;
        }

        wallet.setAmount(wallet.getAmount() - Double.parseDouble(data.get("amount")));
        walletRepository.save(wallet);

        Payment payment = new Payment();
        payment.setAmount(Double.parseDouble(data.get("amount")));
        payment.setConsumerNumber(data.get("consumerNumber"));
        payment.setBillNumber(data.get("billNumber"));
        payment.setCreatedAt(new Date());
        payment.setBill(billRepository.findBillById(Integer.parseInt(data.get("bill_id"))));
        payment.setUser(userRepository.findUserById(Integer.parseInt(data.get("user_id"))));
        payment.setWallet(wallet);

        paymentRepository.save(payment);

        return true;
    }


}
