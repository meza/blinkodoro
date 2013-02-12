package hu.meza.blinkodoro;

public class Clock {

    public void pause(int waitTime) {

        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            return;
        }

    }

    public long currentTimeInMillis() {
        return System.currentTimeMillis();
    }

    public int minutes(int minute) {

        final int secondsInAMinute = 60;
        final int millisInASecond = 1000;

        return secondsInAMinute * millisInASecond * minute;
    }
}
