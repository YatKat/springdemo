package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;
import mate.academy.springdemo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getAllProjectsOfDeveloper(Developer developer) {
        return projectRepository.findProjectsByName(developer.getName());
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("ProjectServiceImpl is done");
        System.out.println("=============================================");
    }
}
