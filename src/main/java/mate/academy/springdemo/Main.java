package mate.academy.springdemo;

import mate.academy.springdemo.config.Config;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.repository.DeveloperRepository;
import mate.academy.springdemo.service.DeveloperService;
import mate.academy.springdemo.service.DeveloperServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Spring Context initialize");
    }
}
