package mate.academy.springdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mate.academy.springdemo.model.Developer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillsDTO {
    private  Long id;
    private  String language;
    private  String level;
    private Developer developer;
}
