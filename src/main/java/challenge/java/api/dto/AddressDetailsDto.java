package challenge.java.api.dto;

import challenge.java.api.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressDetailsDto(
        @NotBlank
        Long id,
        @NotBlank
        String street,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zip,
        @NotBlank
        String city,
        @NotBlank
        String number,

        @NotNull
        boolean mainAddress,

        Long personId) {
        public AddressDetailsDto(Address address) {
                this(address.getId(), address.getStreet(), address.getZip(), address.getCity(), address.getNumber(), address.getMainAddress(), address.getPerson().getId());
        }
}
