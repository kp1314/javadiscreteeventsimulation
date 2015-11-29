package simulation;

import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Created by kp1314 on 11/02/15.
 */
public abstract class Simulation {

  protected Double currentVirtualTime = 0.0;
  protected Queue<ScheduledEvent> scheduledEvents = new PriorityQueue<ScheduledEvent>();
  protected ScheduledEvent currentScheduledEvent;

  protected abstract boolean stop();

  public Double getCurrentVirtualTime() {
    return currentVirtualTime;
  }

  public void schedule(Event e, Double offSet) {
    scheduledEvents.add(new ScheduledEvent(e, (offSet +
        currentVirtualTime)));
  }

  public void simulate() {
    while ((!stop() && !scheduledEvents.isEmpty())) {
     currentScheduledEvent = scheduledEvents.poll();
      currentVirtualTime = currentScheduledEvent.getFixedTime();
       currentScheduledEvent.getCurrentEvent().invoke(this);
    }
  }
}
