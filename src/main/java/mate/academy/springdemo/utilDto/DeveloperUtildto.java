package mate.academy.springdemo.utilDto;

import mate.academy.springdemo.dto.input.DeveloperDtoInput;
import mate.academy.springdemo.dto.output.DeveloperDtoOutput;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;

import java.util.ArrayList;
import java.util.List;

public class DeveloperUtildto {

    public static DeveloperDtoOutput convertToDeveloperDto(Developer developer){
        DeveloperDtoOutput devOutDto = new DeveloperDtoOutput();
        devOutDto.setId(developer.getId());
        devOutDto.setName(developer.getName());
        devOutDto.setAge(developer.getAge());
        devOutDto.setSalary(developer.getSalary());
        return devOutDto;
    }

    public static Developer convertToDeveloper(DeveloperDtoInput developerDtoInput){
        Developer developer = new Developer();
        developer.setName(developerDtoInput.getName());
        developer.setAge(developerDtoInput.getAge());
        developer.setSalary(developerDtoInput.getSalary());
//        developer.setSkills(developerDtoInput.getSkills());
//        List<Project> list = new ArrayList<>();
//        list. add(developerDtoInput.getProject());
//        developer.setProjectList(list);
        return developer;
    }
}
