package pl.denisolek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.denisolek.entities.Project;
import pl.denisolek.entities.User;
import pl.denisolek.repository.ProjectRepository;

import java.util.List;
import java.util.Set;

@RestController(value = "projects")
public class ProjectController {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(value = "/api/projects", method = RequestMethod.GET)
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @RequestMapping(value = "/api/projects/{projectId}", method = RequestMethod.GET)
    public Project findProject(@PathVariable("projectId") long projectId) {
        return projectRepository.findOne(projectId);
    }

    @RequestMapping(value = "/api/projects/{projectId}/members", method = RequestMethod.GET)
    public Set<User> findProjectMembers(@PathVariable("projectId") long projectId) {
        Project project = projectRepository.findOne(projectId);

        return project.getUsers();
    }

}
