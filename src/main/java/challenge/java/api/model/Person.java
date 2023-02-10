package challenge.java.api.model;

import challenge.java.api.dto.PersonDto;
import challenge.java.api.dto.UpdatePersonDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void update(UpdatePersonDto data) throws ParseException {
        if(data.name() != null){
            this.name = data.name();
        }

        if(data.dateBirth() != null){
            this.dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(data.dateBirth());
        }
    }
}
