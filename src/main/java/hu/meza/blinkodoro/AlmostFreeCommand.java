package hu.meza.blinkodoro;

import java.awt.Color;

import thingm.blink1.Blink1;

public class AlmostFreeCommand implements Command {

    public static final int WAIT_BETWEEN_ACTIONS = 500;
    private final Blink1 blinker;
    private final Clock clock;

    public AlmostFreeCommand(Blink1 blinker, Clock clock) {

        this.blinker = blinker;
        this.clock = clock;
    }

    @Override
    public void execute() {
        blinker.fadeToRGB(WAIT_BETWEEN_ACTIONS, Color.YELLOW);
        clock.pause(WAIT_BETWEEN_ACTIONS);
        blinker.fadeToRGB(WAIT_BETWEEN_ACTIONS, Color.BLACK);
        clock.pause(WAIT_BETWEEN_ACTIONS);
    }
}
