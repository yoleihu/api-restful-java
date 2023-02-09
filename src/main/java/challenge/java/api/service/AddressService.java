package challenge.java.api.service;

import challenge.java.api.model.Address;
import challenge.java.api.model.Person;
import challenge.java.api.repository.AddressRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AddressService {

    @Autowired
    private static AddressRepository repository;

    @PostConstruct
    public static void chageMainAddress(Person person){
        Optional<Address> main = repository.findAllByPerson(person)
                .stream().filter(a -> a.getMainAddress().equals(true)).findFirst();
        
        if(main.isPresent()){
            main.get().setMainAddress(false);
            repository.save(main.get());
        }
    }
}
