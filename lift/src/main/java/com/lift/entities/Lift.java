package com.lift.entities;

import java.util.List;

/**
 * All {@link Lift} type of objects must implement this class to implement the
 * basic lift related functionalities.
 * 
 * @author shivam.maharshi
 */
public interface Lift extends Entity<Integer> {

  public boolean close();

  public int getLevel();

  public int getMinLevel();

  public int getMaxLevel();

  public int getMaxWeight();

  public List<Integer> getQueue();

  public LiftState getState();

  public LiftType getType();

  public int getWeight();

  public boolean isOverloaded();

  public boolean move();

  public Integer nextStop();

  public boolean open();

}
