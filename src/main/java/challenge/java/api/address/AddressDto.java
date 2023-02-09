package challenge.java.api.address;

import challenge.java.api.person.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDto(
        @NotBlank
        String street,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zip,
        @NotBlank
        String city,
        @NotBlank
        String number,

        Long personId) {
}
