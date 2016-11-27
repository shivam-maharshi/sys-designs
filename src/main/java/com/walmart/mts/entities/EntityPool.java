package com.walmart.mts.entities;

import java.util.List;
import java.util.Map;

import com.walmart.mts.allocator.EntityAllocator;

/**
 * Must be implemented by all objects representing a pool/collection of
 * {@link Entity} objects.
 * 
 * @author shivam.maharshi
 */
public interface EntityPool<K> {

  /**
   * Returns a specific {@link Entity} from the pool.
   * 
   * @param obj
   *          - Represents the inputs to uniquely identify a specific object.
   * @return Entity - Returns an {@link Entity} object from the pool.
   */
  public K get(Object... obj);

  /**
   * Returns the current size of the {@link EntityPool}.
   * 
   * @return Size - Current size of the entity pool.
   */
  public int size();

  /**
   * Returns the maximum capacity of the {@link EntityPool}.
   * 
   * @return MaxCapacity - Maximum capacity of the entity pool.
   */
  public int maximumCapacity();
  
  /**
   * Returns the internal data structure that holds the pool.
   * {@link EntityAllocator} needs access to this object for request
   * manipulation to efficiently allocate an {@link Entity} from this pool.
   * 
   * @return Object - The data structure used to store {link Entity} like
   *         {@link List}, {@link Map}, etc.
   */
  public Object getPool();

}
