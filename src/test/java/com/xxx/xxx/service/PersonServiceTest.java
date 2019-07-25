package com.xxx.xxx.service;


import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.utils.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("com.xxx.xxx.utils.SalaryCalculator")
@PrepareForTest(TimeUnit.class)
public class PersonServiceTest {
    @InjectMocks
    private PersonService personService;

    @Test
    public void should_get_person_named_none_none_when_name_is_not_james() {
        // given

        // when
        PersonRequest request = new PersonRequest("LIANG MING");
        Person result = personService.find(request);

        // then
        assertThat(result.getFirstName()).isEqualTo("None");
        assertThat(result.getLastName()).isEqualTo("None");
        assertThat(result.getSalary()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void should_get_person_named_merson_james_when_name_is_james() {
        // given
        suppress(method(TimeUnit.class, "sleep"));

        // when
        PersonRequest request = new PersonRequest("James");
        Person result = personService.find(request);

        // then
        assertThat(result.getFirstName()).isEqualTo("Merson");
        assertThat(result.getLastName()).isEqualTo("James");
        assertThat(result.getSalary()).isEqualTo(BigDecimal.TEN.add(BigDecimal.TEN));
    }
}