package vnuk.cse.scbanking.pattern.walletfactory;

import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.entity.WalletType.ShoppingWallet;

public class ShoppingWalletFactory extends WalletFactory {
    @Override
    public Wallet createWallet(User user,String name, String description, String createdAt) {
        return new ShoppingWallet(user, name, description, createdAt);
    }
}
