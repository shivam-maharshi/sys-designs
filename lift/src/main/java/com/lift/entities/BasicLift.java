package com.lift.entities;

import java.util.Queue;

/**
 * A {@link Lift} implementation with just the basic functionalities
 * implemented.
 * 
 * @author shivam.maharshi
 */
public class BasicLift implements Lift<Integer> {

  @Override
  public Integer getId() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean close() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Queue<Integer> getQueue() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LiftState getState() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isOverloaded() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean move() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int next() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean open() {
    // TODO Auto-generated method stub
    return false;
  }
  
}
