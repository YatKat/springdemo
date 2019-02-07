package mate.academy.springdemo.controller;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        System.out.println("DEV CONTROLLER");
        Developer developer = new Developer();
        developer.setName("name1");
        developer.setAge(24);
        developer.setSalary(1500);
        developerService.create(developer);
        return "/index";
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("DeveloperController is done");
        System.out.println("=============================================");
    }

    @RequestMapping(value = "/developer/{id}", method = RequestMethod.GET)
    public String getDeveloperInfo(@PathVariable Long id, ModelAndView view){
        Developer developer = developerService.get(id);
        view.addObject("developer", developer);
        return "/developer/info";
    }
}
