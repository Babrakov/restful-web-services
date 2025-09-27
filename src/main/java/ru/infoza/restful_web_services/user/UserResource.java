package ru.infoza.restful_web_services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserResource {

    private final UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userDaoService.findById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userDaoService.save(user);
    }

}
