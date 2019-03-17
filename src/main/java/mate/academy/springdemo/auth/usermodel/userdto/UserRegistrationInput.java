package mate.academy.springdemo.auth.usermodel.userdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationInput {
    private String login;
    private String password;
}
