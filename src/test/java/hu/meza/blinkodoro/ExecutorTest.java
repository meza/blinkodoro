package hu.meza.blinkodoro;

import org.junit.Test;
import org.mockito.Mockito;

import hu.meza.blinkodoro.commands.Command;

public class ExecutorTest {

    @Test
    public void testTiming() {
        final int waitTime = 500;
        Clock clock = Mockito.mock(Clock.class);
        Executor executor = new Executor(clock);

        Command command = Mockito.mock(Command.class);

        executor.executeFor(command, waitTime);

        Mockito.verify(clock, Mockito.times(1)).pause(Mockito.eq(waitTime));
        Mockito.verify(command, Mockito.times(1)).execute();

    }

    @Test
    public void repeat() {
        final int repeatTime = 500;

        Clock clock = Mockito.mock(Clock.class);
        Mockito.when(clock.currentTimeInMillis())
            .thenReturn(0l)    //init
            .thenReturn(0l)    //first cycle
            .thenReturn(100l)  //second cycle
            .thenReturn(600l); //third cycle over the wait time

        Executor executor = new Executor(clock);
        Command command = Mockito.mock(Command.class);

        executor.repeatFor(command, repeatTime);

        Mockito.verify(command, Mockito.times(2)).execute();


    }

}
