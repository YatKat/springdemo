package mate.academy.springdemo.auth.usermodel.userdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginInput {
    private String login;
    private String password;
}
