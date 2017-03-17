package pl.denisolek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.denisolek.entities.User;
import pl.denisolek.repository.UserRepository;

import java.util.List;

@RestController(value = "users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/api/users/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable("userId") long userId) {
        return userRepository.findOne(userId);
    }

}
