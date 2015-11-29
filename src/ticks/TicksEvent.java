package ticks;

import simulation.Event;
import simulation.Simulation;

/**
 * Created by kp1314 on 13/02/15.
 */
public class TicksEvent implements Event {

  private static Double offset;

  protected TicksEvent(Double offset) {
    this.offset = offset;
  }
  @Override
  public void invoke(Simulation simulation) {
    System.out.println("Tick at: " + simulation.getCurrentVirtualTime());
    simulation.schedule(new TicksEvent(offset), offset);
  }
}
