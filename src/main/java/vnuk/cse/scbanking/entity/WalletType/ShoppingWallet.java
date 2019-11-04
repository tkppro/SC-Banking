package vnuk.cse.scbanking.entity.WalletType;

import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="wallets")
@DiscriminatorValue("WS")
public class ShoppingWallet extends Wallet implements Serializable {
    public  ShoppingWallet() {}
    public ShoppingWallet(User user,String name, String description, String createdAt) {
        super(user, name, description,createdAt);
    }
}
