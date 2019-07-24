package com.xxx.xxx.controller;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
    @Mock
    private PersonService personService;
    @InjectMocks
    private PersonController controller;

    @Test
    public void should_get_name() {
        // given

        // when
        Person person = new Person("LIANG", "MING", BigDecimal.ONE);
        when(personService.find(any(PersonRequest.class))).thenReturn(person);

        String name = "LIANG MING";
        String result = controller.getName(name);

        // then
        verify(personService).find(any(PersonRequest.class));
        assertThat(result).isEqualTo("LIANG,MING");
    }

}