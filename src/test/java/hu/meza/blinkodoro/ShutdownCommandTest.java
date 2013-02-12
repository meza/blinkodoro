package hu.meza.blinkodoro;

import java.awt.Color;

import org.junit.Test;
import org.mockito.Mockito;

import thingm.blink1.Blink1;

public class ShutdownCommandTest {

    @Test
    public void setsTheLedsOff() {
        Blink1 blinker = Mockito.mock(Blink1.class);

        ShutdownCommand command = new ShutdownCommand(blinker);
        command.execute();

        Mockito.verify(blinker, Mockito.atLeastOnce()).setRGB(Mockito.eq(Color.BLACK));

    }

}
