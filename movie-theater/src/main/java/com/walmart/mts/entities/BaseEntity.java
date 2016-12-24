package com.walmart.mts.entities;

/**
 * Entities must extend this class to reuse fields. Currently all {@link Entity}
 * must have a unique identifier.
 * 
 * @author shivam.maharshi
 *
 * @param <T>
 */
public class BaseEntity<T> implements Entity<T> {

  protected T id;

  public T getId() {
    return id;
  }

}
