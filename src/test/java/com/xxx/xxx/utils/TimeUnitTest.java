package com.xxx.xxx.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.doThrow;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Thread.class})
public class TimeUnitTest {
    @Mock
    InterruptedException exception;

    @Test
    public void should_sleep() {
        // given
        PowerMockito.mockStatic(Thread.class);
        doNothing().when(Thread.class);

        // when
        TimeUnit.sleep(100);

        // then
        PowerMockito.verifyStatic(Thread.class, times(1));
    }

    @Test
    public void should_print_backtrace_when_sleep_get_exception() {
        // given
        PowerMockito.mockStatic(Thread.class);

        doThrow(exception).when(Thread.class);
        Mockito.doNothing().when(exception).printStackTrace();

        // when
        TimeUnit.sleep(100);

        // then
        verify(exception).printStackTrace();
    }
}