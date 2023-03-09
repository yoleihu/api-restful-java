package challenge.java.api.controller;

import challenge.java.api.dto.UpdatePersonDto;
import challenge.java.api.model.Address;
import challenge.java.api.repository.AddressRepository;
import challenge.java.api.model.Person;
import challenge.java.api.dto.PersonDto;
import challenge.java.api.repository.PersonRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public ResponseEntity<Page<Person>> list(Pageable pagination) {
        var page = repository.findAll(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable Long id) {
        var person = repository.findById(id);
        return ResponseEntity.ok(person);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdatePersonDto data) throws ParseException {
        Optional<Person> person = repository.findById(data.id());
        person.get().update(data);

        return ResponseEntity.ok(new UpdatePersonDto(person.get().getId(), person.get().getName(), person.get().getDateBirth().toString()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        List<Address> adresses= addressRepository.findAllByPerson(repository.findById(id));
        adresses.forEach(adress -> addressRepository.deleteById(adress.getId()));
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
