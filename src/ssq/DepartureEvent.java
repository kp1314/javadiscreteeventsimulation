package ssq;

import simulation.Event;
import simulation.Simulation;

/**
 * Created by kp1314 on 13/02/15.
 */
public class DepartureEvent implements Event{

  @Override
  public void invoke(Simulation simulation) {
    SingleServerQueue ssq = (SingleServerQueue)simulation;
    ssq.decreasePopulation();
    System.out.println("Departure at " + simulation.getCurrentVirtualTime() +
        ", new population = " + ssq.getPopulation());
    if (ssq.getPopulation() > 0) {
      simulation.schedule(new DepartureEvent(), 0.25);
    }
  }

}
