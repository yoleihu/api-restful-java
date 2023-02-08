package challenge.java.api.person;

import challenge.java.api.address.AddressDto;

public record PersonDto(String name, String dateBirth, AddressDto address) {
}
