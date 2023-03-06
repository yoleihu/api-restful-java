package challenge.java.api.repository;

import challenge.java.api.model.Address;
import challenge.java.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByPerson(Person person);

    List<Address> findAllByPerson(Optional<Person> byId);
}
