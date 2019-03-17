package mate.academy.springdemo.service;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Skills;
import mate.academy.springdemo.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public Skills createSkillsOnDeveloper(Developer developer, Skills skills) {
        skills.setDeveloper(developer);
        return skillsRepository.save(skills);
    }

    @Override
    public Skills getSkillsById(Long id) {
        return skillsRepository.findById(id).get();
    }

    @PostConstruct
    public void postConstruct() {
        log.info("SkillsServiceImpl is done");
    }
}
