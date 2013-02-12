package hu.meza.blinkodoro;

import java.awt.Color;

import org.junit.Test;
import org.mockito.Mockito;

import thingm.blink1.Blink1;

public class AlmostFreeCommandTest {

    @Test
    public void almostFreeBlinksYellow() throws InterruptedException {

        Blink1 blinker = Mockito.mock(Blink1.class);
        Clock clock = Mockito.mock(Clock.class);

        AlmostFreeCommand command = new AlmostFreeCommand(blinker, clock);
        command.execute();

        Mockito.verify(blinker, Mockito.times(1)).fadeToRGB(
            Mockito.eq(AlmostFreeCommand.WAIT_BETWEEN_ACTIONS),
            Mockito.eq(Color.YELLOW)
        );
        Mockito.verify(clock, Mockito.times(2)).pause(AlmostFreeCommand.WAIT_BETWEEN_ACTIONS);
        Mockito.verify(blinker, Mockito.times(1)).fadeToRGB(
            Mockito.eq(AlmostFreeCommand.WAIT_BETWEEN_ACTIONS),
            Mockito.eq(Color.BLACK)
        );
    }
}
