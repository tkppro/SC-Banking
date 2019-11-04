package vnuk.cse.scbanking.pattern.paymentfactory.walletfactory;

import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;

public abstract class WalletFactory {
    public abstract Wallet createWallet(User user,String name, String description, String createdAt);
}