package com.lift.allocator;

import com.lift.entities.Lift;
import com.lift.request.LiftAllocationRequest;

/**
 * Closest in path allocator algorithm allocates the closest lift traveling in
 * the direction of floor from which the {@link LiftAllocationRequest} has
 * originated.
 * 
 * @author shivam.maharshi
 */
public class ClosestInPathLiftAllocator implements LiftAllocator<Integer> {

  @Override
  public Lift<Integer> allocate(Object liftPool, LiftAllocationRequest request) {
    return null;
  }

}
