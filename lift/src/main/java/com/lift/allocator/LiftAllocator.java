package com.lift.allocator;

import com.lift.entities.Entity;

/**
 * All classes that perform the allocation of an {@link Entity} must implement
 * this interface.
 * 
 * @author shivam.maharshi
 */
public interface LiftAllocator<K, M> {

  /**
   * Allocates a list of {@link Entity} from the input {@link EntityPool} &
   * request.
   * 
   * @param entityPool
   *          - {@link EntityPool} from which a list of {@link Entity} will be
   *          allocated.
   * @param request
   *          - A request object based on which allocation will take place.
   * @return {@link List<Entity>} - A list of allocated {@link Entity}.
   */
  public M allocate(K request);

}