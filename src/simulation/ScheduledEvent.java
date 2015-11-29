package simulation;

/**
 * Created by kp1314 on 11/02/15.
 */
public class ScheduledEvent<S> implements Comparable<ScheduledEvent> {

  private Double fixedTime;
  private Event currentEvent;

  public ScheduledEvent(Event currentEvent, Double fixedTime) {
    this.fixedTime = fixedTime;
    this.currentEvent = currentEvent;
  }

  public Double getFixedTime() {
    return fixedTime;
  }

  public Event getCurrentEvent() {
    return currentEvent;
  }

  @Override
  public int compareTo(ScheduledEvent SE) {
    return fixedTime.compareTo(SE.getFixedTime());
  }
}
