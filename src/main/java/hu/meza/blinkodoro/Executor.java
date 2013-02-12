package hu.meza.blinkodoro;

public class Executor {
    private Clock clock;

    public Executor(Clock clock) {

        this.clock = clock;
    }

    public void execute(Command command, int waitTime) {
        command.execute();
        clock.pause(waitTime);
    }

    public void repeat(Command command, int repeatTime) {
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
