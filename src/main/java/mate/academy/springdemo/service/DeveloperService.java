package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Developer;
import java.util.List;

public interface DeveloperService {
    Developer create(Developer dev);
    Developer get(Long id);
    List<Developer> getDevelopersWithSalaryGt(Integer salary);
}
