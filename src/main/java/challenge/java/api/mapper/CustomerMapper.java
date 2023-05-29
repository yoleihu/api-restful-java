package challenge.java.api.mapper;

import challenge.java.api.model.Customer;
import challenge.java.api.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static CustomerDto toDto(Customer customer){
        return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone());
    }

    public static Customer toEntity(CustomerDto customerDto){
        return new Customer(customerDto.id(), customerDto.name(), customerDto.email(), customerDto.phone());
    }

    public static List<CustomerDto> toDoList(List<Customer> customers) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = toDto(customer);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }
}
