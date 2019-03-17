package mate.academy.springdemo.utilDto;

import mate.academy.springdemo.dto.input.ProjectDtoInput;
import mate.academy.springdemo.dto.output.ProjectDtoOutput;
import mate.academy.springdemo.model.Project;

public class ProjectUtilDto {

    public static ProjectDtoOutput convertToProjectDtoOutput(Project project){
        ProjectDtoOutput projectDtoOutput = new ProjectDtoOutput();
        projectDtoOutput.setId(project.getId());
        projectDtoOutput.setName(project.getName());
        projectDtoOutput.setCompany(project.getCompany());
        projectDtoOutput.setCustomer(project.getCustomer());
        projectDtoOutput.setCost(project.getCost());
        projectDtoOutput.setDevelopersList(project.getDevelopersList());
        return projectDtoOutput;
    }

    public static Project convertToProject(ProjectDtoInput projectDtoInput){
        Project project = new Project();
        project.setName(projectDtoInput.getName());
        project.setCompany(projectDtoInput.getCompany());
        project.setCustomer(projectDtoInput.getCustomer());
        project.setCost(projectDtoInput.getCost());
        project.setDevelopersList(projectDtoInput.getDevelopersList());
        return project;
    }
}
