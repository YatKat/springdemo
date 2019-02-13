package mate.academy.springdemo.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mate.academy.springdemo.model.Company;
import mate.academy.springdemo.model.Customer;
import mate.academy.springdemo.model.Developer;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDtoOutput {
    private Long id;
    private String name;
    private Integer cost;
    private List<Developer> developersList;
    private Company company;
    private Customer customer;
}
