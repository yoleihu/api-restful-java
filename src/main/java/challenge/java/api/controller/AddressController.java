package challenge.java.api.controller;

import challenge.java.api.address.Address;
import challenge.java.api.address.AddressDto;
import challenge.java.api.address.AddressRepository;
import challenge.java.api.person.Person;
import challenge.java.api.person.PersonRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressRepository repository;
    @Autowired
    private PersonRespository personRespository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid AddressDto data) {
        Person person = personRespository.findById(data.personId()).orElseThrow(RuntimeException::new);
        repository.save(new Address(data, person));
    }
}
