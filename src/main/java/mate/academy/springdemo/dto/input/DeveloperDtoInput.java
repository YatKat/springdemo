package mate.academy.springdemo.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDtoInput {
    private String name;
    private Integer age;
    private Integer salary;
}
