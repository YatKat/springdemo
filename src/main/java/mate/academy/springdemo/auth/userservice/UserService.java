package mate.academy.springdemo.auth.userservice;

import mate.academy.springdemo.auth.usermodel.User;
import org.springframework.stereotype.Service;


public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
