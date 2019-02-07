package mate.academy.springdemo.auth.usercontroller;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.auth.usermodel.User;
import mate.academy.springdemo.auth.userservice.SecurityService;
import mate.academy.springdemo.auth.userservice.UserService;
import mate.academy.springdemo.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
public class UserController {
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){
        if(error != null){
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        log.info("login controller is working");
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        log.info("registration form is working");
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult result, Model model){
        userValidator.validate(userForm, result);

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        log.info("register controller is working");
        return "redirect:/welcome";
    }
}
