package com.lift.entities;

import java.util.Queue;

/**
 * All {@link Lift} type of objects must implement this class to implement the
 * basic lift related functionalities.
 * 
 * @author shivam.maharshi
 *
 * @param <K>
 */
public interface Lift<K> extends Entity<K> {

  public boolean close();

  public Queue<Integer> getQueue();

  public LiftState getState();

  public boolean isOverloaded();

  public boolean move();

  public int next();

  public boolean open();

}
