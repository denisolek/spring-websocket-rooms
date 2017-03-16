package pl.denisolek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.denisolek.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
}
