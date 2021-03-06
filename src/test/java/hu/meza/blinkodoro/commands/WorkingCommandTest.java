package hu.meza.blinkodoro.commands;

import java.awt.Color;

import org.junit.Test;
import org.mockito.Mockito;

import hu.meza.blinkodoro.commands.WorkingCommand;
import thingm.blink1.Blink1;

public class WorkingCommandTest {


    @Test
    public void inProgressTurnsRed() {

        Blink1 blinker = Mockito.mock(Blink1.class);

        WorkingCommand command = new WorkingCommand(blinker);
        command.execute();
        Mockito.verify(blinker, Mockito.atLeastOnce()).setRGB(Mockito.eq(Color.RED));

    }
}
