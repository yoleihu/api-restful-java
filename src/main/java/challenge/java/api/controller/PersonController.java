package challenge.java.api.controller;

import challenge.java.api.model.Address;
import challenge.java.api.repository.AddressRepository;
import challenge.java.api.model.Person;
import challenge.java.api.dto.PersonDto;
import challenge.java.api.repository.PersonRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    @Transactional
    public  HttpStatus create(@RequestBody @Valid PersonDto data) throws Exception {
        try{
            Person person = new Person(data);
            repository.save(person);
            addressRepository.save(new Address(data.address(), person));
            return HttpStatus.CREATED;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
