package hu.meza.blinkodoro;

import java.awt.Color;

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
