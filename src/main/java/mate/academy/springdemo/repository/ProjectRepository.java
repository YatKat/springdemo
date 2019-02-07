package mate.academy.springdemo.repository;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectsByName(String developerName);
}
