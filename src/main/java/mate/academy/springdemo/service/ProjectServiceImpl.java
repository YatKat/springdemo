package mate.academy.springdemo.service;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;
import mate.academy.springdemo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("projectService")
@Log4j2
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
    public List<Project> getAll() {
        projectRepository.findAll();
        return null;
    }

    @Override
    public Project updateProjectInfo(Long id, Project newProject) {
        Project oldProject = projectRepository.findById(id).get();
        newProject.setId(oldProject.getId());
        projectRepository.delete(oldProject);
        projectRepository.save(newProject);
        return newProject;
}

    @Override
    public Long deleteProject(Long id) {
        Project project = projectRepository.findById(id).get();
        projectRepository.delete(project);
        return id;
    }


    @PostConstruct
    public void postConstruct() {
        log.info("ProjectServiceImpl is done");
    }
}
