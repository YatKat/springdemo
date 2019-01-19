package mate.academy.springdemo.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("userService")
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        System.out.println("Default constructor");
    }
    public void printMyName() {
        System.out.println("My name is Katia");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("UserServiceIml destroy");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set");
    }
}
