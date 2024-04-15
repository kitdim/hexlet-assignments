package exercise.controller;

import exercise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import exercise.service.UserService;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public Flux<User> getUsers() {
        return userService.findAll();
    }

    // BEGIN
    @GetMapping(path = "/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
    @PostMapping("")
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PatchMapping(path = "/{id}")
    public Mono<User> updateUser(@RequestBody User userData, @PathVariable Long id) {
        return userService.update(userData, id);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
    // END
}
