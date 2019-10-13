package vnuk.cse.scbanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vnuk.cse.scbanking.entity.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
}