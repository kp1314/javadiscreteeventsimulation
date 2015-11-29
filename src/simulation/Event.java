package simulation;

/**
 * Created by kp1314 on 11/02/15.
 */
public interface Event<S> {

  public void invoke(S simulation);

}
