package challenge.java.api.person;

import challenge.java.api.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name = "persons")
@Entity(name = "Person")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dateBirth;

    @OneToMany
    private List<Address> address;

    public Person(PersonDto data) {
        this.name = data.name();
        this.dateBirth = data.dateBirth();
        this.address.add(new Address(data.address()));
    }
}
