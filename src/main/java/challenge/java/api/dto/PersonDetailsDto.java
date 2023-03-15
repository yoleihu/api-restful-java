package challenge.java.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PersonDetailsDto(
        @NotBlank
        String name,
        @NotBlank
        String dateBirth,
        @Valid
        List<AddressListDto> addresses) {

}
