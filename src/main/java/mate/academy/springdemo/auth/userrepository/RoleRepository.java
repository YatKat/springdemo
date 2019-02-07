package mate.academy.springdemo.auth.userrepository;

import mate.academy.springdemo.auth.usermodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
