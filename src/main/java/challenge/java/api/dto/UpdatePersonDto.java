package challenge.java.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePersonDto(@NotNull Long id,
                              String name,
                              String dateBirth) {
}
