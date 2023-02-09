package challenge.java.api.person;

import challenge.java.api.address.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonDto(
        @NotBlank
        String name,
        @NotBlank
        String dateBirth,
        @Valid
        AddressDto address) {
}
