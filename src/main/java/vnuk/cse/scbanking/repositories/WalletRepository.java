package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.Wallet;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    List<Wallet> findAll();
}
