package hu.meza.blinkodoro;

import org.junit.Test;

import junit.framework.Assert;

public class ClockTest {


    Clock clock = new Clock();

    @Test
    public void testPause() {

    }

    @Test
    public void currentTimeInMillis() {

    }

    @Test
    public void minutes() {

        final int input = 5;
        final int expected = 300000;
        final int actual = clock.minutes(input);

        Assert.assertEquals("The minutes were not calculated properly", expected, actual);

    }
}
