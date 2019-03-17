package mate.academy.springdemo.controller;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.dto.input.ProjectDtoInput;
import mate.academy.springdemo.model.Project;
import mate.academy.springdemo.service.CompanyService;
import mate.academy.springdemo.service.ProjectService;
import mate.academy.springdemo.utilDto.ProjectUtilDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/project")
@Log4j2
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/")
    public List<Project> getAllProjects(){
        List<Project> projectList = projectService.getAll();
        return projectList;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        if (project == null) {
            return new ResponseEntity("No Project found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Project> addProject(@RequestBody ProjectDtoInput projectDtoInput){
        Project project = ProjectUtilDto.convertToProject(projectDtoInput);
        Long id = projectService.createProject(project).getId();
        project.setId(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<Project> editProjectById(@PathVariable Long id){
       Project oldProject = projectService.getProjectById(id);
        if (null == oldProject) {
            return new ResponseEntity("No Project found for ID " + id, HttpStatus.NOT_FOUND);
        }
        Project newProject = projectService.updateProjectInfo(id, oldProject);
        return new ResponseEntity<>(newProject, HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        if (null == project) {
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
       projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("ProjectController is done");
    }
}
