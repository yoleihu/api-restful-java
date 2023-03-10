package challenge.java.api.controller;

import challenge.java.api.dto.AddressListDto;
import challenge.java.api.dto.PersonDto;
import challenge.java.api.model.Address;
import challenge.java.api.dto.AddressDto;
import challenge.java.api.repository.AddressRepository;
import challenge.java.api.model.Person;
import challenge.java.api.repository.PersonRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
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
    public ResponseEntity register(@RequestBody @Valid AddressDto data, UriComponentsBuilder uriBuilder) throws Exception {
        try{
            Person person = personRespository.findById(data.personId()).orElseThrow(RuntimeException::new);

            Optional<Address> main = repository.findAllByPerson(person)
                    .stream().filter(a -> a.getMainAddress().equals(true)).findFirst();

            if(main.isPresent() && data.mainAddress()){
                main.get().setMainAddress(false);
                repository.save(main.get());
            }

            Address address = new Address(data, person);
            repository.save(address);

            var uri = uriBuilder.path("/address/{id}").buildAndExpand(address.getId()).toUri();

            return ResponseEntity.created(uri).body(new AddressDto(address.getStreet(), address.getZip(), address.getCity(), address.getNumber(), address.getMainAddress(), address.getPerson().getId()));

        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<List<AddressListDto>> findByAllByPersonId(@PathVariable Long id) throws Exception {
        try{
            List<AddressListDto> addresses = repository.findAllByPerson(personRespository.findById(id).get()).
                    stream().map(AddressListDto::new).toList();
            return ResponseEntity.ok(addresses);
        }catch (Exception e){
            throw new Exception(e);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> findById(@PathVariable Long id) {
        Optional<Address> address = repository.findById(id);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
