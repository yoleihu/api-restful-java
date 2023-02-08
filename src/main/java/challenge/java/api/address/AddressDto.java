package challenge.java.api.address;

import challenge.java.api.person.Person;

public record AddressDto(String street, String zip, String city, String number, Long personid) {
}
