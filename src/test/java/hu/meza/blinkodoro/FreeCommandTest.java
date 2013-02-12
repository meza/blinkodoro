package hu.meza.blinkodoro;

import java.awt.Color;

import org.junit.Test;
import org.mockito.Mockito;

import thingm.blink1.Blink1;

public class FreeCommandTest {

    @Test
    public void freeTurnsGreen() {

        Blink1 blinker = Mockito.mock(Blink1.class);

        FreeCommand command = new FreeCommand(blinker);
        command.execute();

        Mockito.verify(blinker, Mockito.atLeastOnce()).setRGB(Mockito.eq(Color.GREEN));

    }

}
