package hu.meza.blinkodoro;

import hu.meza.blinkodoro.commands.AlmostFreeCommand;
import hu.meza.blinkodoro.commands.FreeCommand;
import hu.meza.blinkodoro.commands.ShutdownCommand;
import hu.meza.blinkodoro.commands.WorkingCommand;
import thingm.blink1.Blink1;

public class Blinkodoro {


    public static final int CYCLES = 4;
    public static final int BUSY_WORKING = 18;
    public static final int ALMOST_FREE_COUNTDOWN = 2;
    public static final int FREE_TIME = 5;

    public static void main(String[] args) {
        Blink1 blinker = new Blink1();
        Clock clock = new Clock();
        Executor executor = new Executor(clock);

        AlmostFreeCommand almostFreeCommand = new AlmostFreeCommand(blinker, clock);
        FreeCommand freeCommand = new FreeCommand(blinker);
        WorkingCommand workingCommand = new WorkingCommand(blinker);
        ShutdownCommand shutdownCommand = new ShutdownCommand(blinker);

        blinker.open();
        for (int cycle = 0; cycle < CYCLES; cycle++) {
            executor.executeFor(workingCommand, clock.minutes(BUSY_WORKING));
            executor.repeatFor(almostFreeCommand, clock.minutes(ALMOST_FREE_COUNTDOWN));
            executor.executeFor(freeCommand, clock.minutes(FREE_TIME));
        }

        shutdownCommand.execute();
        blinker.close();

    }
}

