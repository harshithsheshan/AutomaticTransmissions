package transmission;

/**
 * Transmissions are represented by the speed a car is traveling and the gear
 * that the car is in when it is traveling that speed.
 */
public interface Transmission {

  /**
   * Increases the speed by 1 MPH updating the gear appropriately.
   */
  void increaseSpeed();

  /**
   * Decreases the speed by 1 MPH updating the gear appropriately.
   *
   * @throws IllegalStateException if called would cause the speed to go below 0
   */
  void decreaseSpeed() throws IllegalStateException;

  /**
   * Gets the speed of this Transmission.
   * 
   * @return the speed
   */
  int getSpeed();

  /**
   * Gets the gear of this Transmission.
   * 
   * @return the gear
   */
  int getGear();

  /**
   * gets Threshold.
   */
  int getT1();

  /**
   * gets Threshold.
   */
  int getT2();

  /**
   * gets Threshold.
   */
  int getT3();

  /**
   * gets Threshold.
   */
  int getT4();

  /**
   * gets Threshold.
   */
  int getT5();

}
