package mate.academy.springdemo.service;

import mate.academy.springdemo.exceptions.NoDeveloperException;
import mate.academy.springdemo.model.Developer;
import java.util.List;

public interface DeveloperService {
    Developer create(Developer dev);
    Developer get(Long id);
    List<Developer> getDevelopersWithSalaryGt(Integer salary);
    List<Developer> getAllDevs();
    void delete(Long id);
    void update(Long id, Developer developer);
}
