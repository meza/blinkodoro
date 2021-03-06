package hu.meza.blinkodoro.commands;

import java.awt.Color;

import hu.meza.blinkodoro.commands.Command;
import thingm.blink1.Blink1;

public class WorkingCommand implements Command {


    private Blink1 blinker;

    public WorkingCommand(Blink1 blinker) {
        this.blinker = blinker;
    }

    @Override
    public void execute() {
        blinker.setRGB(Color.RED);
    }
}
