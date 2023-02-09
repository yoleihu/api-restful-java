package challenge.java.api;

import challenge.java.api.controller.PersonController;
import challenge.java.api.dto.PersonDto;
import challenge.java.api.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

public class PersonTest {

    private PersonController personController;

    @Test
    public void createPersonSucess() throws Exception {
        PersonDto personDtoMock = Mockito.mock(PersonDto.class);
        HttpStatus person = personController.create(personDtoMock);

    }
}
