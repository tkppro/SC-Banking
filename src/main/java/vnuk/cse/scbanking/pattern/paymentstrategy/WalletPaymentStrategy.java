package vnuk.cse.scbanking.pattern.paymentstrategy;

import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.*;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentFactory;
import vnuk.cse.scbanking.service.WalletService;

import java.util.Map;

@Service
public class WalletPaymentStrategy implements PaymentStrategy {
    WalletService walletService;

    public WalletPaymentStrategy(WalletService walletService)
    {
        this.walletService = walletService;
    }
    @Override
    public Payment pay(Map<String, String> data, PaymentFactory paymentFactory, User user, Bill bill) {
        Wallet wallet = this.walletService.findWalletById(Integer.parseInt(data.get("wallet_id")));

        wallet.setAmount(wallet.getAmount() - Double.parseDouble(data.get("amount")));
        this.walletService.save(wallet);

        Payment payment = paymentFactory.createPayment(data.get("consumerNumber"), data.get("billNumber"),
                Double.parseDouble(data.get("amount")), wallet, user, bill);

        return payment;
    }
}
