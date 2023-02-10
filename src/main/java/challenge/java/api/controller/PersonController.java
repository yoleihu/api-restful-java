package challenge.java.api.controller;

import challenge.java.api.model.Address;
import challenge.java.api.repository.AddressRepository;
import challenge.java.api.model.Person;
import challenge.java.api.dto.PersonDto;
import challenge.java.api.repository.PersonRespository;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRespository repository;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    @Transactional
    public  HttpStatus create(@RequestBody @Valid PersonDto data) throws Exception {
        try{
            Person person = new Person(data);
            repository.save(person);
            addressRepository.save(new Address(data.address(), person));
            return CREATED;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping
    public List<Person> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable Long id) {
        return repository.findById(id);
    }
}
