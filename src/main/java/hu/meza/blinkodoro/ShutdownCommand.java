package hu.meza.blinkodoro;

import java.awt.Color;

import thingm.blink1.Blink1;

public class ShutdownCommand implements Command {
    private Blink1 blinker;

    public ShutdownCommand(Blink1 blinker) {
        this.blinker = blinker;
    }

    @Override
    public void execute() {
        blinker.setRGB(Color.BLACK);
    }
}
