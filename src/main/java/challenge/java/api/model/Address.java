package challenge.java.api.model;


import challenge.java.api.dto.AddressDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "address")
@Entity(name = "Address")
@Getter
@Setter
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

    private Boolean mainAddress;

    @ManyToOne
    private Person person;

    public Address(AddressDto data, Person person) {
        this.street = data.street();
        this.zip = data.zip();
        this.city = data.city();
        this.number = data.number();
        this.mainAddress = data.mainAddress();
        this.person = person;
    }
}

