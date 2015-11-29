package ssq;

import simulation.Event;
import simulation.Simulation;
import java.util.Random;

/**
 * Created by kp1314 on 13/02/15.
 */
public class ArrivalEvent implements Event {

  private Random pseudoRandomList;
  protected static final Double SERVICE_TIME = 0.25;


  protected ArrivalEvent(Random pseudoRandomList) {
    this.pseudoRandomList = pseudoRandomList;

  }

  @Override
  public void invoke(Simulation simulation) {
    SingleServerQueue ssq = (SingleServerQueue)simulation;
    Double nextArrivalTime = pseudoRandomList.nextDouble();
    int population = ssq.getPopulation();
    if (population == 0) {
      ssq.increasePopulation();
      System.out.println("Arrival at " + simulation.getCurrentVirtualTime() +
          ", new population = " + ssq.getPopulation());
      simulation.schedule(new ArrivalEvent(pseudoRandomList), nextArrivalTime);
      simulation.schedule(new DepartureEvent(), SERVICE_TIME);
    } else {
      ssq.increasePopulation();
      System.out.println("Arrival at " + simulation.getCurrentVirtualTime() +
          ", new population = " + ssq.getPopulation());
      simulation.schedule(new ArrivalEvent(pseudoRandomList), nextArrivalTime);
    }
  }
}
