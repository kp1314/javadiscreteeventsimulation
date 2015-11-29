

/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {

  /* declarations required */
  private boolean carIsWaitingAtPlatform;

  public PlatformAccess() {
    this.carIsWaitingAtPlatform = false;
  }

  public void arrive() throws InterruptedException {
    // complete implementation
    while (carIsWaitingAtPlatform) wait();
      carIsWaitingAtPlatform = true;
  }

  public synchronized void depart() {
    // complete implementation
    carIsWaitingAtPlatform = false;
    notify();
  }

}