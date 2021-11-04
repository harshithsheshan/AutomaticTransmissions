package transmission;

/**
 * Class to create an Automatic Transmission mechanism which changes gears according to the speed.
 */
public class AutomaticTransmission implements Transmission {

  private int speed;
  private int gear;
  private final int t1;
  private final int t2;
  private final int t3;
  private final int t4;
  private final int t5;

  /**
   * Constructor to initialize values.
   *
   * @param t1    Threshold
   * @param t2    Threshold
   * @param t3    Threshold
   * @param t4    Threshold
   * @param t5    Threshold
   */
  public AutomaticTransmission( int t1, int t2, int t3, int t4, int t5 ) {
    this.speed = 0;
    if ( t1 < 0 || t2 < 0 || t3 < 0 || t4 < 0 || t5 < 0) {
      throw new IllegalArgumentException();
    }
    if ( !(0 < t1 && t1 < t2 && t2 < t3 && t3 < t4 && t4 < t5 )) {
      throw new IllegalArgumentException();
    }
    this.t1 = t1;
    this.t2 = t2;
    this.t3 = t3;
    this.t4 = t4;
    this.t5 = t5;

    computeGear();
  }

  /**
   * Return Thresholds.
   * @return t1
   */
  public int getT1() {
    return this.t1;
  }

  /**
   * Return Thresholds.
   * @return t2
   */
  public int getT2() {
    return this.t2;
  }

  /**
   * Return Thresholds.
   * @return t3
   */
  public int getT3() {
    return this.t3;
  }

  /**
   * Return Thresholds.
   * @return t4
   */
  public int getT4() {
    return this.t4;
  }

  /**
   * Return Thresholds.
   * @return t5
   */
  public int getT5() {
    return this.t5;
  }

  /**
   * Increases the speed by 1 MPH updating the gear appropriately.
   */
  public void increaseSpeed() {
    this.speed++;
    computeGear();
  }


  /**
   * Decreases the speed by 1 MPH updating the gear appropriately.
   *
   * @throws IllegalStateException if called would cause the speed to go below 0
   */
  public void decreaseSpeed() {
    if (this.speed - 1 >= 0) {
      this.speed--;
      computeGear();
    }
    else {
      throw new IllegalStateException();
    }
  }

  /**
   * Gets the speed of this Transmission.
   *
   * @return the speed
   */
  public int getSpeed() {
    return this.speed;
  }

  /**
   * Gets the gear of this Transmission.
   *
   * @return the gear
   */
  public int getGear() {
    return this.gear;
  }


  /**
   * Compute the gear for a particular speed and set Gear accordingly.
   */
  private void computeGear() {
    if (speed == 0) {
      this.gear = 0;
    }
    if (isBetween(1, t1)) {
      this.gear = 1;
    }
    if (isBetween(t1, t2)) {
      this.gear = 2;
    }
    if (isBetween(t2, t3)) {
      this.gear = 3;
    }
    if (isBetween(t3, t4)) {
      this.gear = 4;
    }
    if (isBetween(t4, t5)) {
      this.gear = 5;
    }
    if (this.speed >= t5) {
      this.gear = 6;
    }

  }


  /**
   * Helper function to check if speed is in range for a particular gear.
   *
   * @param a lower limit
   * @param b higher limit
   * @return boolean
   */
  boolean isBetween(int a, int b) {
    return  this.speed >= a && this.speed < b;
  }


  @Override
  public String toString() {
    return (String.format("Transmission (speed = %d, gear = %d)", this.speed, this.gear));
  }
}

