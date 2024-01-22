package exercise.controller;

import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Person;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person show(@PathVariable long id) {
        return personRepository.findById(id).get();
    }

    // BEGIN
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Person> index(
            @RequestParam(defaultValue = "1") long page,
            @RequestParam(defaultValue = "10") long limit) {
        return personRepository.findAll().stream()
                .skip((page - 1) * limit)
                .limit(limit)
                .toList();
    }

    @PostMapping(path = "/people")
    @ResponseStatus(HttpStatus.CREATED)
    public Person save(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void destroy(@PathVariable String id) {
        personRepository.deleteById(Long.getLong(id));
    }
    // END
}
