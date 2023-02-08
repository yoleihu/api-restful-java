package challenge.java.api.person;

import challenge.java.api.address.AddressDto;

import java.util.Date;

public record PersonDto(String name, Date dateBirth, AddressDto address) {
}
