package challenge.java.api.controller;

import challenge.java.api.dto.*;
import challenge.java.api.model.Address;
import challenge.java.api.repository.AddressRepository;
import challenge.java.api.model.Person;
import challenge.java.api.repository.PersonRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRespository repository;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid PersonDto data, UriComponentsBuilder uriBuilder) throws Exception {
        try{
            Person person = new Person(data);
            repository.save(person);
            Address address = new Address(data.address(), person);
            addressRepository.save(address);

            var uri = uriBuilder.path("/person/{id}").buildAndExpand(person.getId()).toUri();

            return ResponseEntity.created(uri).body(
                    new PersonDto(person.getName(), person.getDateBirth().toString(),
                    new AddressDto(address.getStreet(), address.getZip(), address.getCity(), address.getNumber(), address.getMainAddress(), address.getPerson().getId())));
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
    public ResponseEntity<PersonDetailsDto> findById(@PathVariable Long id) {
        var person = repository.getReferenceById(id);
        return ResponseEntity.ok(new PersonDetailsDto(person.getName(), person.getDateBirth().toString()));
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
        List<Address> addresses= addressRepository.findAllByPerson(repository.getReferenceById(id));
        addresses.forEach(adress -> addressRepository.deleteById(adress.getId()));
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
