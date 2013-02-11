import org.junit.Test;
import org.mockito.Mockito;

import thingm.blink1.Blink1;

public class BlinkodoroTest {

    private Blink1 blinker = Mockito.mock(Blink1.class);


    @Test
    public void inProgressTurnsRed() {

        working();
        Mockito.verify(blinker, Mockito.atLeastOnce()).setRGB(
            Mockito.eq(255),
            Mockito.eq(0),
            Mockito.eq(0)
        );

    }

    @Test
    public void freeTurnsGreen() {

        free();
        Mockito.verify(blinker, Mockito.atLeastOnce()).setRGB(
            Mockito.eq(0),
            Mockito.eq(255),
            Mockito.eq(0)
        );

   }

   @Test
   public void almostFreeBlinksYellow() throws InterruptedException {

       almostFree();
       Mockito.verify(blinker, Mockito.times(1)).fadeToRGB(
           Mockito.eq(500),
           Mockito.eq(255),
           Mockito.eq(255),
           Mockito.eq(0)
       );

       Mockito.verify(blinker, Mockito.times(1)).fadeToRGB(
           Mockito.eq(500),
           Mockito.eq(0),
           Mockito.eq(0),
           Mockito.eq(0)
       );
   }


   @Test
   public void lofasz() {
       blinker = new Blink1();
       blinker.open();
       working();
       sleep(1000);
       for(int i=1; i<10; i++) {
        almostFree();
       }
       free();
       sleep(1000);
       blinker.setRGB(0,0,0);
       blinker.close();
   }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {

        }
    }

    private void almostFree() {
        blinker.fadeToRGB(500, 255, 255, 0);
        sleep(500);
        blinker.fadeToRGB(500,0,0,0);
        sleep(500);

    }


    private void free() {
        blinker.setRGB(0,255,0);
    }

    private void working() {
        blinker.setRGB(255,0,0);
    }

}
