package mate.academy.springdemo.repository;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectsByName(String projectName);
}
