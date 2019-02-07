package mate.academy.springdemo.auth.userrepository;

import mate.academy.springdemo.auth.usermodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
