package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.repositories.UserRepository;
import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findUserByEmail(String email) { return userRepository.findUserByEmail(email); }

    public User fingUserById(int id) {
        return userRepository.findUserById(id);
    }

}
