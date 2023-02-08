package challenge.java.api.address;


import challenge.java.api.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "address")
@Entity(name = "Address")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zip;
    private String city;
    private String number;

    @ManyToOne
    private Person person;

    public Address(AddressDto data) {
        this.street = data.street();
        this.zip = data.zip();
        this.city = data.city();
        this.number = data.number();
        this.person = data.person();
    }

    public Address(AddressDto address, Person person) {
        this.street = address.street();
        this.zip = address.zip();
        this.city = address.city();
        this.number = address.number();
        this.person = person;
    }
}
