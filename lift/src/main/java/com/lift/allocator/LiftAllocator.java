package com.lift.allocator;

import com.lift.entities.Lift;
import com.lift.request.LiftAllocationRequest;

/**
 * All classes that perform the allocation of an {@link Lift} must implement
 * this interface.
 * 
 * @author shivam.maharshi
 */
public interface LiftAllocator<K> {

  /**
   * Allocates a {@link Lift} from the input lift pool & request.
   * 
   * @param liftPool
   *          - Lift pool from which a list of {@link Lift} is allocated.
   * @param request
   *          - A {@link LiftAllocationRequest} object based on which allocation
   *          for {@link Lift} will take place.
   * @return {@link Lift} - An allocated {@link Lift} to satisfy the
   *         {@link LiftAllocationRequest} request.
   */
  public Lift<K> allocate(Object liftPool, LiftAllocationRequest request);

}