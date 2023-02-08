package challenge.java.api.controller;

import challenge.java.api.address.Address;
import challenge.java.api.address.AddressDto;
import challenge.java.api.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody AddressDto data) {
        repository.save(new Address(data));
    }
}
