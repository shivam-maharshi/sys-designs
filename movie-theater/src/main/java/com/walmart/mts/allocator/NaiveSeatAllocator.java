package com.walmart.mts.allocator;

import java.util.List;

import com.walmart.mts.entities.EntityPool;
import com.walmart.mts.entities.Seat;

/**
 * Sample code to show the usage of {@link SeatAllocator}. Naive seat allocation
 * algorithm in which the next free seats are reserved without taking into
 * account their position with respect to each other. Class only exists to show
 * sample usage.
 * 
 * @author shivam.maharshi
 */
public class NaiveSeatAllocator implements SeatAllocator<Integer> {

  /**
   * {@inheritDoc}
   */
  public List<Seat> allocate(EntityPool<Seat> entityPool, Integer request) {
    throw new RuntimeException("Method not implemented.");
  }

}
