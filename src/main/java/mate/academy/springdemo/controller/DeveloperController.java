package mate.academy.springdemo.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.dto.input.DeveloperDtoInput;
import mate.academy.springdemo.dto.output.DeveloperDtoOutput;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;
import mate.academy.springdemo.service.DeveloperService;
import mate.academy.springdemo.utilDto.DeveloperUtildto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/developer")
@Log4j2
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    // REST approach
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DeveloperDtoOutput> getAll(){
        List<Developer> developers = developerService.getAllDevs();
        return  developers
                .stream()
                .map(DeveloperUtildto::convertToDeveloperDto)
                .collect(Collectors.toList());
    }
//Using model approach
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDeveloperInfo(@PathVariable Long id, ModelMap map){
        Developer developer = developerService.get(id);
        DeveloperDtoOutput developerDtoOutput = DeveloperUtildto.convertToDeveloperDto(developer);
        map.put("developer", developerDtoOutput);
        return "developers/info";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getDevelopersInfo(ModelMap map){
        List<Developer> developers = developerService.getAllDevs();
        List<DeveloperDtoOutput> devsOut = developers.stream()
                .map(DeveloperUtildto::convertToDeveloperDto)
                .collect(Collectors.toList());
        map.put("developers", devsOut);
        return "developers/main";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createDeveloper() {
        return "developers/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createDeveloper(@ModelAttribute("developer") DeveloperDtoInput dev) {
        Developer developer = DeveloperUtildto.convertToDeveloper(dev);
        Long id = developerService.create(developer).getId();
        developer.setId(id);
        //hardcode to put the project into developer's List of projects;
        List<Project> projectList = new ArrayList<>();
        Project project = new Project();
        project.setName("HelloWorld");
        project.setCost(28000000);
        project.setDevelopersList(Collections.singletonList(developer));
        projectList.add(project);
        developer.setProjectList(projectList);
        log.info("Developer created!");
        return "redirect:/developer/main";
    }

    //for creating developer with ajax

    @RequestMapping(value = "/createDev", method = RequestMethod.GET)
    public String getjQuerydevs(){
        return "developers/createDev";
    }

    @ResponseBody
    @RequestMapping(value = "/createDev", method = RequestMethod.POST)
    public ResponseEntity<DeveloperDtoOutput> createjQuerydevs(@RequestBody DeveloperDtoInput developerDtoInput){
        Developer developer = DeveloperUtildto.convertToDeveloper(developerDtoInput);
        Long id = developerService.create(developer).getId();
        developer.setId(id);
        return new ResponseEntity<>(DeveloperUtildto.convertToDeveloperDto(developer), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity deleteDev(@PathVariable Long id){
        developerService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity updateDev(@RequestBody DeveloperDtoInput developerDtoInput, @PathVariable Long id){
        Developer oldDeveloper = developerService.get(id);
        Developer updatedDeveloper = DeveloperUtildto.convertToDeveloper(developerDtoInput);
        updatedDeveloper.setId(id);
        developerService.delete(oldDeveloper.getId());
        developerService.create(updatedDeveloper);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("DeveloperController is done");
    }
}
