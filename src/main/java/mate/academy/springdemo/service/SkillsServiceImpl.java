package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Skills;
import mate.academy.springdemo.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
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
        return skillsRepository.getOne(id);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("SkillsServiceImpl is done");
        System.out.println("=============================================");
    }
}
