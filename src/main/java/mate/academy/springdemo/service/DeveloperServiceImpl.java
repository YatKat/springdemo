package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

@Component("developerService")
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    public Developer create(Developer dev) {
        return developerRepository.save(dev);
    }

    public Developer get(Long id) {
        return developerRepository.getOne(id);
    }

    public List<Developer> getDevelopersWithSalaryGt(Integer salary) {
        return developerRepository.findAllBySalaryGreaterThan(salary);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("DeveloperServiceImpl is done");
        System.out.println("=============================================");
    }
}
