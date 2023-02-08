package challenge.java.api.controller;

import challenge.java.api.person.Person;
import challenge.java.api.person.PersonDto;
import challenge.java.api.person.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRespository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody PersonDto data) {
        repository.save(new Person(data));
    }
}
