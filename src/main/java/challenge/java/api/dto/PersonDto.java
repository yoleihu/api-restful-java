package challenge.java.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PersonDto(
        @NotBlank
        String name,
        @NotBlank
        String dateBirth,
        @Valid
        AddressDto address) {
}
