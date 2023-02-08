package challenge.java.api.person;

import challenge.java.api.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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


    public Person(PersonDto data) throws ParseException {
        this.name = data.name();
        this.dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(data.dateBirth());
    }
}
