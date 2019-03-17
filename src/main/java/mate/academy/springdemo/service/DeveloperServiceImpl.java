package mate.academy.springdemo.service;
import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;


@Component("developerService")
@Log4j2
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    public Developer create(Developer dev) {
        return developerRepository.save(dev);
    }

    public Developer get(Long id) {
            return developerRepository.findById(id).get();
    }

    public List<Developer> getDevelopersWithSalaryGt(Integer salary) {
        return developerRepository.findAllBySalaryGreaterThan(salary);
    }

    @Override
    public List<Developer> getAllDevs() {
        return developerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Developer developer = developerRepository.findById(id).get();
        developerRepository.delete(developer);
    }

    @Override
    public void update(Long id, Developer developer) {
        Developer oldDeveloper = developerRepository.findById(id).get();
        developer.setId(oldDeveloper.getId());
        developerRepository.delete(oldDeveloper);
        developerRepository.save(developer);
    }


    @PostConstruct
    public void postConstruct() {
        log.info("DeveloperServiceImpl is done");
    }
}
