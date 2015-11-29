package ssq;

import java.util.Random;
import simulation.Simulation;

/**
 * Created by kp1314 on 11/02/15.
 */
public class SingleServerQueue extends Simulation {

  private static int population = 0;
  private Double endTime;
  private int populationSum;
  private int populationChangeCounter;
  private static final double SERVICE_TIME = 0.25;

  protected SingleServerQueue(Double endTime) {
    this.endTime = endTime;
  }

  protected boolean stop() {
    return this.currentVirtualTime + SERVICE_TIME >= endTime ;
  }

  double getMeanQueueLength() {
    return populationSum/populationChangeCounter;
  }

  int getPopulation() {
    return population;
  }

  void increasePopulation() {
    populationSum += population;
    populationChangeCounter += 1;
    population++;
  }

  void decreasePopulation() {
    populationSum += population;
    populationChangeCounter += 1;
    population--;
  }


  public static void main(String[] args) {
    long seed = Long.parseLong(args[0]);
    double endTime = Double.parseDouble(args[1]);
    Random interArrivalTimes = new Random(seed);
    Double nextArrivalTime = interArrivalTimes.nextDouble();
    Simulation ssq = new SingleServerQueue(endTime);
    ssq.schedule(new ArrivalEvent(interArrivalTimes), nextArrivalTime);
    ssq.simulate();
    System.out.println("SIMULATION COMPLETE - the mean queue length was "
        + ((SingleServerQueue) ssq).getMeanQueueLength());
  }
}
