package challenge.java.api.dto;

import challenge.java.api.model.Address;
import challenge.java.api.model.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressListDto(@NotBlank
                             String street,
                             String zip,
                             String city,
                             String number,
                             boolean mainAddress) {

    public AddressListDto(Address data) {
        this(data.getStreet(), data.getZip(), data.getCity(), data.getNumber(), data.getMainAddress());
    }
}
