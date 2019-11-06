package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.TopUp;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.entity.WalletType.WalletType;
import vnuk.cse.scbanking.pattern.walletfactory.BillingWalletFactory;
import vnuk.cse.scbanking.pattern.walletfactory.ShoppingWalletFactory;
import vnuk.cse.scbanking.pattern.walletfactory.WalletFactory;
import vnuk.cse.scbanking.repositories.CardRepository;
import vnuk.cse.scbanking.repositories.TopUpRepository;
import vnuk.cse.scbanking.repositories.UserRepository;
import vnuk.cse.scbanking.repositories.WalletRepository;

import java.util.List;

@Service
public class WalletService {
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    TopUpRepository topUpRepository;
    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserRepository userRepository;

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public Wallet findWalletById(int id) {
        return walletRepository.findWalletById(id);
    }

    public WalletFactory walletFactory(int walletId) {
        switch (walletId){
            case WalletType.WALLET_BILLING:
                return new BillingWalletFactory();
            case WalletType.WALLET_SHOPPING:
                return new ShoppingWalletFactory();
            default:
                return null;
        }
    }

    public void save (Wallet wallet) {
         walletRepository.save(wallet);
    }

    public void newWallet (Wallet wallet) {
        WalletFactory walletFactory = walletFactory(1);
        Wallet newWallet = walletFactory.createWallet(userRepository.findUserById(2),wallet.getName(), wallet.getDescription(), wallet.getCreatedAt());
        walletRepository.save(newWallet);
    }

    public boolean transfer(int fromWalletId,int toWalletId, double amount)
    {
        Wallet fromWallet = this.findWalletById(fromWalletId);
        if(fromWallet != null && fromWalletId != toWalletId)
        {
            if(fromWallet.getAmount() >= amount)
            {
                Wallet toWallet = this.findWalletById(toWalletId);
                fromWallet.setAmount(fromWallet.getAmount() - amount);
                toWallet.setAmount(toWallet.getAmount() + amount);

                this.save(fromWallet);
                this.save(toWallet);

                return true;
            }
        }

        return false;
    }

    public boolean topup(int walletId, double amount, int cardId, int userId)
    {
        Wallet wallet = this.findWalletById(walletId);
        Card card = cardRepository.findById(cardId);
        User user = userRepository.findUserById(userId);
        TopUp topup = new TopUp(card , user, wallet, amount);
        if(wallet != null)
        {
            wallet.setAmount(wallet.getAmount() + amount);
            topUpRepository.save(topup);
            this.save(wallet);
            return true;
        }
        return false;
    }
}
