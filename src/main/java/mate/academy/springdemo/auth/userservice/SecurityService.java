package mate.academy.springdemo.auth.userservice;

import org.springframework.stereotype.Service;


public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

//    void doLogin(UserLoginInput userLoginInput);
}
