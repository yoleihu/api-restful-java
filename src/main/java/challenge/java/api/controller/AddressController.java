package challenge.java.api.controller;

import challenge.java.api.dto.AddressListDto;
import challenge.java.api.model.Address;
import challenge.java.api.dto.AddressDto;
import challenge.java.api.repository.AddressRepository;
import challenge.java.api.model.Person;
import challenge.java.api.repository.PersonRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public HttpStatus register(@RequestBody @Valid AddressDto data) throws Exception {
        try{
            Person person = personRespository.findById(data.personId()).orElseThrow(RuntimeException::new);
            if ( data.mainAddress() == true ){
                Optional<Address> main = repository.findAllByPerson(person)
                        .stream().filter(a -> a.getMainAddress().equals(true)).findFirst();

                if(main.isPresent()){
                    main.get().setMainAddress(false);
                    repository.save(main.get());
                }
            }
            repository.save(new Address(data, person));
            return HttpStatus.CREATED;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping("/{id}")
    public List<AddressListDto> findById(@PathVariable Long id) throws Exception {
        try{
            return repository.findAllByPerson(personRespository.findById(id).get()).
                    stream().map(AddressListDto::new).toList();
        }catch (Exception e){
            throw new Exception(e);
        }

    }
}
