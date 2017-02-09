package com.lift.entities;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A {@link Lift} implementation with just the basic functionalities
 * implemented.
 * 
 * @author shivam.maharshi
 */
public class BasicLift implements Lift<Integer> {
  
  private int id;
  private int level;
  private Queue<Integer> queue;
  private LiftState state;
  private LiftType type;
  private int minLevel;
  private int maxLevel;
  private int maxWeight;
  private int weight;

  public BasicLift(int id, int level, LiftState state, LiftType type, int minLevel,
      int maxLevel, int maxWeight) {
    super();
    this.id = id;
    this.level = level;
    this.queue = new LinkedList<>();
    this.state = state;
    this.type = type;
    this.minLevel = minLevel;
    this.maxLevel = maxLevel;
    this.maxWeight = maxWeight;
    this.weight = 0;
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public boolean close() {
    // Invokes the embedded function to close the door.
    return true;
  }

  @Override
  public int getLevel() {
    return level;
  }

  @Override
  public Queue<Integer> getQueue() {
    return queue;
  }

  @Override
  public LiftState getState() {
    return state;
  }
  
  @Override
  public LiftType getType() {
    return type;
  }

  @Override
  public boolean isOverloaded() {
    return maxWeight < weight;
  }

  @Override
  public boolean move() {
    // Invokes the embedded function to move the lift.
    return true;
  }

  @Override
  public Integer nextStop() {
    return queue.isEmpty() ? null : queue.peek();
  }

  @Override
  public boolean open() {
    // Invokes the embedded function to move the lift.
    return true;
  }

  @Override
  public int getMinLevel() {
    return minLevel;
  }

  @Override
  public int getMaxLevel() {
    return maxLevel;
  }

  @Override
  public int getMaxWeight() {
    return maxWeight;
  }

  @Override
  public int getWeight() {
    // Invokes the embedded function to update the weight.
    return weight;
  }

}
