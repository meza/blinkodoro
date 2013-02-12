package hu.meza.blinkodoro;

import hu.meza.blinkodoro.commands.Command;

public class Executor {
    private Clock clock;

    public Executor(Clock clock) {

        this.clock = clock;
    }

    public void executeFor(Command command, int waitTime) {
        command.execute();
        clock.pause(waitTime);
    }

    public void repeatFor(Command command, int repeatTime) {
        long startTime = clock.currentTimeInMillis();

        while (true) {
            long currentTime = clock.currentTimeInMillis();
            if ((currentTime - startTime) > repeatTime) {
                return;
            }
            command.execute();

        }
    }
}
