package com.walmart.mts.allocator;

import java.util.List;

import com.walmart.mts.entities.Entity;
import com.walmart.mts.entities.EntityPool;

/**
 * All classes that perform the allocation of an {@link Entity} must implement
 * this interface.
 * 
 * @author shivam.maharshi
 */
public interface EntityAllocator<K, M> {

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
  public List<K> allocate(EntityPool<K> entityPool, M request);

}
