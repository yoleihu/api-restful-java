package challenge.java.api.dto;

public record CustomerDto(
        Long id,
        String name,
        String email,
        String phone) {
}
