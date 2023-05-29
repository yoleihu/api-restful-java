package challenge.java.api.controller;

import challenge.java.api.model.Customer;
import challenge.java.api.dto.CustomerDto;
import challenge.java.api.mapper.CustomerMapper;
import challenge.java.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer createdCustomer = customerService.createCustomer(customer);
        CustomerDto createdCustomerDto = CustomerMapper.toDto(createdCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomerDto);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
        Customer existingCustomer = customerService.getCustomerById(customerId);
        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        Customer updatedCustomer = CustomerMapper.toEntity(customerDto);
        updatedCustomer.setId(customerId);
        Customer savedCustomer = customerService.updateCustomer(customerId, updatedCustomer);
        CustomerDto savedCustomerDto = CustomerMapper.toDto(savedCustomer);
        return ResponseEntity.ok(savedCustomerDto);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        Customer existingCustomer = customerService.getCustomerById(customerId);
        if (existingCustomer == null) {
            return ResponseEntity.notFound().build();
        }
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        CustomerDto customerDto = CustomerMapper.toDto(customer);
        return ResponseEntity.ok(customerDto);
    }
}

