package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.repositories.WalletRepository;

import java.util.List;

@Service
public class WalletService {
    @Autowired
    WalletRepository walletRepository;

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public Wallet findWalletById(int id) {
        return walletRepository.findWalletById(id);
    }

    public void save (Wallet wallet) {
        walletRepository.save(wallet);
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

    public boolean topup(int walletId, double amount)
    {
        Wallet wallet = this.findWalletById(walletId);
        if(wallet != null)
        {
            wallet.setAmount(wallet.getAmount() + amount);
            this.save(wallet);
            return true;
        }
        return false;
    }
}
