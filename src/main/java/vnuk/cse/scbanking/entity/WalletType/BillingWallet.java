package vnuk.cse.scbanking.entity.WalletType;

import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="wallets")
@DiscriminatorValue("WB")
public class BillingWallet extends Wallet implements Serializable {
    public BillingWallet() {}
    public BillingWallet(User user,String name, String description, String createdAt) {
        super(user, name, description,createdAt);
    }
}
