package mate.academy.springdemo;

import mate.academy.springdemo.config.Config;
import mate.academy.springdemo.dao.PersonDao;
import mate.academy.springdemo.model.Person;
import mate.academy.springdemo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Spring Context initialize");
        UserService userService = context.getBean("userService", UserService.class);
        userService.printMyName();

        PersonDao personDao = context.getBean(PersonDao.class);
        Person person = personDao.getById(1);
        Person person1 = new Person();
        person1.setFirstName("Cleo");
        person1.setLastName("Egypt");
        person1.setAge(10);
        personDao.createPerson(person1);
        System.out.println(person.toString());
        ((ConfigurableApplicationContext) context).close();
    }
}
