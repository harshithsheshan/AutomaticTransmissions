package transmission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * To Test methods of AutomaticTransmissionTest.
 */
public class AutomaticTransmissionTest {

  Transmission t = new AutomaticTransmission(15,25,35,45,65);
  int initialGear;

  @Test ( expected = IllegalStateException.class)
  public void checkDecreaseBelow0() {
    t.decreaseSpeed();
  }

  @Test
  public void increaseSpeedTest() {
    //System.out.println(initialGear);
    for (;t.getSpeed() < t.getT5() ; t.increaseSpeed()) {
      initialGear = t.getGear();
      if ( t.getSpeed() == t.getT1() || t.getSpeed() == t.getT2() || t.getSpeed() == t.getT3()
          || t.getSpeed() == t.getT4() || t.getSpeed() == t.getT5() ) {
        t.increaseSpeed();
        assertEquals("Gear Shift Failed", initialGear, t.getGear());
      }
    }
  }

  @Test ( expected = IllegalArgumentException.class)
  public void checkIllegalRange() {
    Transmission t2 = new AutomaticTransmission(20,10,-1,0,90);
  }

  @Test
  public void decreaseSpeedTest() {
    for (;t.getSpeed() > 0 ; t.decreaseSpeed()) {
      if ( t.getSpeed() == t.getT1() || t.getSpeed() == t.getT2() || t.getSpeed() == t.getT3()
          || t.getSpeed() == t.getT4() || t.getSpeed() == t.getT5() ) {
        initialGear = t.getGear();
        t.decreaseSpeed();
        assertEquals("Gear Shift Failed", initialGear, t.getGear());
      }
    }
  }

  @Test
  public void getSpeedTest() {
    assertTrue("Not a valid Speed",t.getSpeed() >= 0 && t.getSpeed() <= 200);
  }

  @Test
  public void getGearTest() {
    assertTrue("Not a valid Gear", t.getGear() >= 0 && t.getGear() <= 6);
  }

}