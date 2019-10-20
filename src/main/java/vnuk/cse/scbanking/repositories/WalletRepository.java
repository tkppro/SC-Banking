package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.Wallet;


public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Wallet findWalletById(int id);
}
