package com.xxx.xxx.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.doNothing;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TimeUnit.class})
public class SalaryCalculatorTest {

    @Test
    public void should_calculate_salary() {
        // given
        PowerMockito.mockStatic(TimeUnit.class);
        doNothing().when(TimeUnit.class);

        // when
        BigDecimal result = SalaryCalculator.calculate(BigDecimal.ONE);

        // then
        assertThat(result).isEqualTo(BigDecimal.ONE.add(BigDecimal.TEN));
    }
}