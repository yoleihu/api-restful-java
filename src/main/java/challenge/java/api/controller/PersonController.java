package challenge.java.api.controller;

import challenge.java.api.address.Address;
import challenge.java.api.address.AddressRepository;
import challenge.java.api.person.Person;
import challenge.java.api.person.PersonDto;
import challenge.java.api.person.PersonRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRespository repository;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PersonDto data) throws ParseException {
        Person person = new Person(data);
        repository.save(person);
        addressRepository.save(new Address(data.address(), person));
    }
}
