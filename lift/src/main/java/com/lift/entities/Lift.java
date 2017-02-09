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

  public int getLevel();

  public int getMinLevel();

  public int getMaxLevel();
  
  public int getMaxWeight();

  public Queue<Integer> getQueue();

  public LiftState getState();

  public LiftType getType();
  
  public int getWeight();

  public boolean isOverloaded();

  public boolean move();

  public Integer nextStop();

  public boolean open();

}
