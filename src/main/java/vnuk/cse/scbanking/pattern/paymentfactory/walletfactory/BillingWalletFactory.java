package vnuk.cse.scbanking.pattern.paymentfactory.walletfactory;

import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.entity.WalletType.BillingWallet;

public class BillingWalletFactory extends WalletFactory {
    @Override
    public Wallet createWallet(User user,String name, String description, String createdAt) {
        return new BillingWallet(user, name, description, createdAt);
        //return null;
    }
}