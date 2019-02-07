package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Skills;

import java.util.List;

public interface SkillsService {
    Skills createSkillsOnDeveloper(Developer developer, Skills skills);
    Skills getSkillsById(Long id);
}
