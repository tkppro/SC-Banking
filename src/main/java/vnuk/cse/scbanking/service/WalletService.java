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

    public void save (Wallet wallet) {
        walletRepository.save(wallet);
    }

    public void update (Wallet wallet) {
        walletRepository.save(wallet);
    }
}
