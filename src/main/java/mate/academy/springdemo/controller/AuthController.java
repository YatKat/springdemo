package mate.academy.springdemo.controller;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.dto.input.UserLoginInput;
import mate.academy.springdemo.dto.input.UserRegistrationInput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
@Log4j2
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        log.info("login controller is working");
        return "auth/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserLoginInput userLoginInput){
        log.info("login controller is working");
        return "/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        log.info("register controller is working");
        return "auth/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(UserRegistrationInput userRegistrationInput){
        log.info("register controller is working");
        return "/";
    }
}
