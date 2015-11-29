package ticks;

import simulation.Simulation;

/**
 * Created by kp1314 on 11/02/15.
 */
public class Ticks extends Simulation {


  public static final double TICKS_LENGTH = 1.0;
  private Double endTime;

  public Ticks(Double endTime) {
    this.endTime = endTime;
  }

  @Override
  protected boolean stop() {
    return endTime.equals(this.getCurrentVirtualTime() + TICKS_LENGTH);
  }

  public static void main(String args[]) {
    Double endTime = Double.parseDouble(args[0]);
    Ticks ticksSimulator = new Ticks(endTime);
    ticksSimulator.schedule(new TicksEvent(TICKS_LENGTH), TICKS_LENGTH);
    ticksSimulator.simulate();
  }

}
