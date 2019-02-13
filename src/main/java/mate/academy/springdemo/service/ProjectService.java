package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(Long id);
    List<Project> getAll();
    Project updateProjectInfo(Long id, Project newProject);
    Long deleteProject(Long id);
}
